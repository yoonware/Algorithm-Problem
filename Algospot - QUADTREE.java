import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int c, pointer;
	static String img;
	
	public static void main(String[] args) {
		
		c = ss.nextInt();
		while(c-- > 0) {
			img     = ss.next();
			pointer = 0; 
			sb.append(dq() + "\n");
		}
		System.out.print(sb.toString());
	}
	
	static String dq() {
		
		char c = img.charAt(pointer++);
		if(c == 'b' || c == 'w')
			return c + "";
		String part1 = dq();
		String part2 = dq();
		String part3 = dq();
		String part4 = dq();
		return "x" + part3 + part4 + part1 + part2;
	}
	
	static class StringScanner {
		
		BufferedReader in;
		StringTokenizer st;
		StringScanner() {
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
	
	static StringScanner ss = new StringScanner();
	static StringBuilder sb = new StringBuilder();
	
}
