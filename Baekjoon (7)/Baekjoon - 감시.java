import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	
	static int n, m, r[][], min, size;
	static ArrayList<Point> point;

	public static void main(String[] args) {
		n     = ss.nextInt();
		m     = ss.nextInt();
		r     = new int[n][m];
		min   = n * m;
		point = new ArrayList<>();
		for(int i = 0; i < n; i ++) {
			for(int j = 0; j < m; j++) {
				r[i][j] = ss.nextInt();
				if(r[i][j] != 0 && r[i][j] != 6)
					point.add(new Point(i, j, r[i][j]));
			}
		}
		dfs(-1, r);
		System.out.print(min);
	}
	
	static void dfs(int index, int board[][]) {
		index++;
		if(index == point.size()) {
			int count = 0;
			for(int i = 0; i < n; i ++)
				for(int j = 0; j < m; j++)
					if(board[i][j] == 0)
						count++;
			min = Math.min(min, count);
			return;
		}
		int y = point.get(index).y;
		int x = point.get(index).x;
		int c = point.get(index).c;
		switch(c) {
			case 1:
				dfs(index, up(y, x, board));
				dfs(index, dn(y, x, board));
				dfs(index, ri(y, x, board));
				dfs(index, le(y, x, board));
				break;
			case 2:
				dfs(index, up(y, x, dn(y, x, board)));
				dfs(index, ri(y, x, le(y, x, board)));
				break;
			case 3:
				dfs(index, up(y, x, ri(y, x, board)));
				dfs(index, up(y, x, le(y, x, board)));
				dfs(index, dn(y, x, ri(y, x, board)));
				dfs(index, dn(y, x, le(y, x, board)));
				break;
			case 4:
				dfs(index, up(y, x, ri(y, x, dn(y, x, board))));
				dfs(index, ri(y, x, dn(y, x, le(y, x, board))));
				dfs(index, dn(y, x, le(y, x, up(y, x, board))));
				dfs(index, le(y, x, up(y, x, ri(y, x, board))));
				break;
			case 5:
				dfs(index, up(y, x, dn(y, x, ri(y, x, le(y, x, board)))));
				break;
		}
	}
	
	static int[][] up(int y, int x, int before[][]) {
		int after[][] = new int[n][m];
		for(int i = 0; i < n; i ++)
			for(int j = 0; j < m; j++)
				after[i][j] = before[i][j];
		for(int i = y; i >= 0; i--) {
			if(after[i][x] == 6)	break;
			else					after[i][x] = 7;
		}
		return after;
	}
	
	static int[][] dn(int y, int x, int before[][]) {
		int after[][] = new int[n][m];
		for(int i = 0; i < n; i ++)
			for(int j = 0; j < m; j++)
				after[i][j] = before[i][j];
		for(int i = y; i < n; i++) {
			if(after[i][x] == 6)	break;
			else					after[i][x] = 7;
		}
		return after;
	}
	
	static int[][] ri(int y, int x, int before[][]) {
		int after[][] = new int[n][m];
		for(int i = 0; i < n; i ++)
			for(int j = 0; j < m; j++)
				after[i][j] = before[i][j];
		for(int i = x; i < m; i++) {
			if(after[y][i] == 6) 	break;
			else					after[y][i] = 7;
		}
		return after;
	}
	
	static int[][] le(int y, int x, int before[][]) {
		int after[][] = new int[n][m];
		for(int i = 0; i < n; i ++)
			for(int j = 0; j < m; j++)
				after[i][j] = before[i][j];
		for(int i = x; i >= 0; i--) {
			if(after[y][i] == 6)	break;
			else					after[y][i] = 7;
		}
		return after;
	}
	
	static class Point {
		int y, x, c;
		Point(int y, int x, int c) {
			this.y = y;
			this.x = x;
			this.c = c;
		}
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