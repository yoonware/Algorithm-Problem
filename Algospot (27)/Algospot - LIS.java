import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int c, n, num[], cache[];
	
	public static void main(String[] args) {

		c = ss.nextInt();
		while(c-- > 0) {
			n = ss.nextInt();
			num = new int[n];
			cache = new int[n];
			for(int i = 0; i < n; i++)
				num[i] = ss.nextInt();
			int max = 0;
			for(int i = 0; i < n; i++) {
				Arrays.fill(cache, -1);
				max = Math.max(max, dp(i));
			}
			sb.append(max + "\n");
		}
		System.out.print(sb.toString());
	}
	
	static int dp(int start) {
		
		if(cache[start] != -1)
			return cache[start];
		
		cache[start] = 1;
		
		for(int i = start+1; i < n; i++)
			if(num[start] < num[i])
				cache[start] = Math.max(cache[start], dp(i) + 1);
		
		return cache[start];
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
