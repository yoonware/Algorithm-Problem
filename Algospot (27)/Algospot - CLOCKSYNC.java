import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static final int INFINITY = 99999;
	static int[] status;

	public static void main(String[] args) {
		
		FastScanner fs = new FastScanner();
		StringBuilder sb = new StringBuilder();
		
		int C = fs.nextInt();
		
		while(C-- > 0) {
			status = new int[16];
			for(int i=0; i<16; i++) {
				status[i] = (fs.nextInt() / 3) % 4;
			}
			
			int min = bruteForce(0);
			if(min == INFINITY) {
				sb.append("-1\n");
			}
			else {
				sb.append(min+"\n");
			}
		}
		
		System.out.print(sb.toString());
	}
	
	static int bruteForce(int button) {
		
		if(button == 10) {
			for(int i=0; i<16; i++) {
				if(status[i] != 0) {
					return INFINITY;
				}
			}
			return 0;
		}
		
		int min = INFINITY;
		for(int i=0; i<4; i++) {
			min = Math.min(min, i + bruteForce(button+1));
			select(button);
		}
		return min;
	}
	
	static void select(int button) {
		
		switch(button) {
			case 0:
				click(0);click(1);click(2);
				break;
			case 1:
				click(3);click(7);click(9);click(11);
				break;
			case 2:
				click(4);click(10);click(14);click(15);
				break;
			case 3:
				click(0);click(4);click(5);click(6);click(7);
				break;
			case 4:
				click(6);click(7);click(8);click(10);click(12);
				break;
			case 5:
				click(0);click(2);click(14);click(15);
				break;
			case 6:
				click(3);click(14);click(15);
				break;
			case 7:
				click(4);click(5);click(7);click(14);click(15);
				break;
			case 8:
				click(1);click(2);click(3);click(4);click(5);
				break;
			case 9:
				click(3);click(4);click(5);click(9);click(13);
				break;
		}
	}
	
	static void click(int clock) {
		
		status[clock] = (status[clock] + 1) % 4;
	}
	
	static class FastScanner {
		
		BufferedReader in;
		StringTokenizer st;
		
		FastScanner() {
			in = new BufferedReader(new InputStreamReader(System.in));
		}
		
		String next() {
			while(st == null || !st.hasMoreTokens()) {
				try {
					String str = in.readLine();
					if(str == null) {
						return null;
					}
					st = new StringTokenizer(str);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}
		
		int nextInt() {
			return Integer.parseInt(next());
		}
	}

}
