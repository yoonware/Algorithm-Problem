import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int c, n, board[][], cache[][];
	static boolean isPossible;

	public static void main(String[] args) {

		c = ss.nextInt();
		while(c-- > 0) {
			n = ss.nextInt();
			board = new int[n][n];
			cache = new int[n][n];
			for(int i = 0; i < n; i++)
				for(int j = 0; j < n; j++) {
					board[i][j] = ss.nextInt();
					cache[i][j] = -1;
				}
			
			if(dp(0, 0) == 1)
				sb.append("YES\n");
			else
				sb.append("NO\n");
		}
		System.out.println(sb.toString());
	}
	
	static int dp(int y, int x) {
		
		if(y >  n-1 || x >  n-1)
			return 0;
		
		if(y == n-1 && x == n-1)
			return 1;
		
		if(cache[y][x] != -1)
			return cache[y][x];
		
		int value = board[y][x];
		
		if(dp(y+value, x) + dp(y, x+value) > 0)
			return cache[y][x] = 1;
		else
			return cache[y][x] = 0;
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
