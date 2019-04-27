import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static FastScanner fs = new FastScanner();
	static StringBuilder sb = new StringBuilder();
	static int c, n, m, answer, picked[], isFriend[][];

	public static void main(String[] args) {
		
		c = fs.nextInt();
		while(c-- > 0) {
			n        = fs.nextInt();
			m        = fs.nextInt();
			answer   = 0;
			picked   = new int[n];
			isFriend = new int[n][n];
			for(int i = 0; i < m; i++) {
				int a = fs.nextInt();
				int b = fs.nextInt();
				isFriend[a][b] = 1;
				isFriend[b][a] = 1;
			}
			if(n % 2 == 0)
				combination(n, 0);
			sb.append(answer + "\n");
		}
		System.out.print(sb.toString());
	}
	
	static void combination(int unPicked, int cand) {
		
		if(unPicked == 0) {
			answer++;
			return;
		}
		for(int i = cand + 1; i < n; i++)
			if(isFriend[cand][i] == 1 && picked[i] == 0) {
				picked[cand] = 1;
				picked[i]  = 1;
				combination(unPicked - 2, getCand());
				picked[cand] = 0;
				picked[i]    = 0;
			}
	}
	
	static int getCand() {
		
		for(int i = 0; i < n; i++)
			if(picked[i] == 0)
				return i;
		return -1;
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
