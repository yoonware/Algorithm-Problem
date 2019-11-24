import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, count;
	static int q[] = new int[13];
	
	public static void main(String[] args) {
		
		FastScanner   fs = new FastScanner();
		StringBuilder sb = new StringBuilder();
		
		int C = fs.nextInt();
		while(C-- > 0) {
			count = 0;
			N = fs.nextInt();
			nqueen(-1);
			sb.append(count+"\n");
		}
		
		System.out.print(sb.toString());
	}
	
	static void nqueen(int row) {
		
		if(row == N-1) {
			count++;
			return;
		}
		for(int col=0; col<N; col++) {
			q[row+1] = col;
			if(check(row+1)) {
				nqueen(row+1);
			}
		}
	}
	
	static boolean check(int row) {
		
		for(int i=0; i<row; i++) {
			if(q[i] == q[row] || row-i == Math.abs(q[row]-q[i])) {
				return false;
			}
		}
		return true;
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
