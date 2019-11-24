import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int c, n, k, index, dead[];
	
	public static void main(String[] args) {
		
		c = ss.nextInt();
		while(c-- > 0) {
			n = ss.nextInt();
			k = ss.nextInt();
			dead  = new int[n];
			index = 0;
			for (int i = 0; i < n-2; i++) {
				if (dead[index] == 0) {
					dead[index] = 1;
					for (int j = 0; j < k; j++) {
						index++;
						if (index > n-1) 		index %= n;
						if (dead[index] == 1) 	j--;
					}	
				}	
			}
			for (int i = 0; i < n; i++)
				if (dead[i] == 0) sb.append(i+1 + " ");
			sb.append("\n");
		}
		System.out.print(sb.toString());
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
