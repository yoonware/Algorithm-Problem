import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int c, n, max, board[][], cache[][];
	
	public static void main(String[] args) {
		
		c = ss.nextInt();
		while(c-- > 0) {
			n = ss.nextInt();
			board = new int[n][n];
			cache = new int[n][n];
			for(int i = 1; i < n+1; i++)
				for(int j = 0; j < i; j++) {
					board[i-1][j] = ss.nextInt();
					cache[i-1][j] = -1;
				}
			sb.append(dp(0, 0) + "\n");	
		}
		System.out.print(sb.toString());
	}
	
	// 완전탐색
	static void bf(int y, int x, int sum) {
		
		sum += board[y][x];
		
		if(y == n-1) {
			max = Math.max(max, sum);
			return;
		}
		
		bf(y+1, x, sum);
		bf(y+1, x+1, sum);
	}
	
	// 동적 계획법
	static int dp(int y, int x) {
		
		if(y == n-1)
			return board[y][x];
		
		if(cache[y][x] != -1)
			return cache[y][x];
		
		return cache[y][x] = Math.max(dp(y+1, x), dp(y+1, x+1)) + board[y][x];
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
