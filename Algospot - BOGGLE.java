import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static FastScanner fs = new FastScanner();
	static StringBuilder sb = new StringBuilder();
	static int     c, n, len, count[];
	static char    board[][];
	static String  word;
	static boolean isFinished, isAlphabetExist;
	
	public static void main(String[] args) {
		
		int c = fs.nextInt();
		while(c-- > 0) {
			board = new char[5][5];
			count = new int[26];
			for(int i=0; i<5; i++) {
				String str = fs.next();
				for(int k=0; k<5; k++) {
					board[i][k] = str.charAt(k);
					count[board[i][k]-'A']++;
				}
			}
			n = fs.nextInt();
			for(int i=0; i<n; i++) {
				word = fs.next();
				isAlphabetExist = true;
				for(int k=0; k<word.length(); k++)
					if(count[word.charAt(k)-'A'] == 0) {
						isAlphabetExist = false;
						break;
					}
				if(isAlphabetExist)
					if(dfsAll())
						sb.append(word + " YES\n");
					else
						sb.append(word + " NO\n");
				else
					sb.append(word + " NO\n");
			}
		}
		System.out.print(sb.toString());
	}
	
	static boolean dfsAll() {
		
		isFinished = false;
		len = word.length();
		char c = word.charAt(0);
		for(int i=0; i<5; i++)
			for(int k=0; k<5; k++)
				if(board[i][k] == c && !isFinished)
					dfs(1, i, k);
		return isFinished;
	}
	
	static void dfs(int level, int y, int x) {
		
		if(level == len) {
			isFinished = true;
			return;
		}
		char c = word.charAt(level);
		if(isFinished) return;
		if(y < 4)
			if(c == board[y+1][x])
				dfs(level+1, y+1, x);
		if(isFinished) return;
		if(y < 4 && x < 4)
			if(c == board[y+1][x+1])
				dfs(level+1, y+1, x+1);
		if(isFinished) return;
		if(x < 4)
			if(c == board[y][x+1])
				dfs(level+1, y, x+1);
		if(isFinished) return;
		if(y > 0 && x < 4)
			if(c == board[y-1][x+1])
				dfs(level+1, y-1, x+1);
		if(isFinished) return;
		if(y > 0)
			if(c == board[y-1][x])
				dfs(level+1, y-1, x);
		if(isFinished) return;
		if(y > 0 && x > 0)
			if(c == board[y-1][x-1])
				dfs(level+1, y-1, x-1);
		if(isFinished) return;
		if(x > 0)
			if(c == board[y][x-1])
				dfs(level+1, y, x-1);
		if(isFinished) return;
		if(y < 4 && x > 0)
			if(c == board[y+1][x-1])
				dfs(level+1, y+1, x-1);
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
