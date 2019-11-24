import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static FastScanner fs = new FastScanner();
	static int m, n, answer_y, answer_x, board[][], visit[][];
	static boolean isCycle;

	public static void main(String[] args) {
		
		n = fs.nextInt();
		m = fs.nextInt();
		board = new int[n][m];
		visit = new int[n][m];
		for(int i = 0; i < n; i++) {
			String line = fs.next();
			for(int k = 0; k < m; k++) {
				board[i][k] = line.charAt(k) - 'A';
			}
		}
		dfsAll();
		if(isCycle)
			System.out.print("Yes");
		else
			System.out.print("No");
	}
	
	static void dfsAll() {
		
		isCycle = false;
		for(int i = 0; i < n; i++)
			for(int k = 0; k < m; k++)
				if(!isCycle) {
					answer_y = i;
					answer_x = k;
					dfs(i, k, 0);
				}
	}
	
	static void dfs(int y, int x, int level) {
		
		if(level >= 4 && y == answer_y && x == answer_x) {
			isCycle = true;
			return;
		}
		int now = board[y][x];
		if(!isCycle && y < n - 1)
			if(now == board[y+1][x] && visit[y+1][x] == 0) {
				visit[y+1][x] = 1;
				dfs(y+1, x, level+1);
				visit[y+1][x] = 0;
			}
		if(!isCycle && x < m - 1)
			if(now == board[y][x+1] && visit[y][x+1] == 0) {
				visit[y][x+1] = 1;
				dfs(y, x+1, level+1);
				visit[y][x+1] = 0;
			}
		if(!isCycle && y > 0)
			if(now == board[y-1][x] && visit[y-1][x] == 0) {
				visit[y-1][x] = 1;
				dfs(y-1, x, level+1);
				visit[y-1][x] = 0;
			}
		if(!isCycle && x > 0)
			if(now == board[y][x-1] && visit[y][x-1] == 0) {
				visit[y][x-1] = 1;
				dfs(y, x-1, level+1);
				visit[y][x-1] = 0;
			}
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
