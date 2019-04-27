import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int c, n, m, A[], B[], cache[][];
	
	public static void main(String[] args) {
		
		c = ss.nextInt();
		while(c-- > 0) {
			n = ss.nextInt();
			m = ss.nextInt();
			A = new int[n];
			B = new int[m];
			cache = new int[n+1][m+1];
			
			for(int i = 0; i < n; i++)
				A[i] = ss.nextInt();
			for(int i = 0; i < m; i++)
				B[i] = ss.nextInt();
			for(int i = 0; i < n+1; i++)
				Arrays.fill(cache[i], -1);
			sb.append(dp(-1, -1) + "\n");
		}
		System.out.print(sb.toString());
	}
	
	static int dp(int indexA, int indexB) {
		
		if(cache[indexA+1][indexB+1] != -1)
			return cache[indexA+1][indexB+1];
		
		cache[indexA+1][indexB+1] = 0;
		
		long a = (indexA == -1 ? Long.MIN_VALUE : A[indexA]);
		long b = (indexB == -1 ? Long.MIN_VALUE : B[indexB]);
		long maxElement = Math.max(a, b);
		
		for(int nextA = indexA + 1; nextA < n; nextA++)
			if(maxElement < A[nextA])
				cache[indexA+1][indexB+1] = Math.max(cache[indexA+1][indexB+1], dp(nextA, indexB) + 1);
		
		for(int nextB = indexB + 1; nextB < m; nextB++)
			if(maxElement < B[nextB])
				cache[indexA+1][indexB+1] = Math.max(cache[indexA+1][indexB+1], dp(indexA, nextB) + 1);
		
		return cache[indexA+1][indexB+1];
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
