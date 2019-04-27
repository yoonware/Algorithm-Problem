import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int before[], after[], diameter[];
	static int min, count;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		
		FastScanner fs = new FastScanner();
		int n = fs.nextInt();
		int p = fs.nextInt();
		
		before   = new int[n+1];
		after    = new int[n+1];
		diameter = new int[n+1];
		
		for(int i=0; i<p; i++) {
			int from       = fs.nextInt();
			int to         = fs.nextInt();
			diameter[from] = fs.nextInt();
			before[to]     = from;
			after[from]    = to;
		}
		
		count = 0;
		sb.append("\n");
		for(int i=1; i<n+1; i++) {
			if(before[i] == 0 && after[i] != 0) {
				count++;
				min = 1000001;
				sb.append(i + " ");
				dfs(i);
			}
		}
		
		System.out.println(count + sb.toString());
	}
	
	static void dfs(int num) {
		
		if(after[num] == 0) {
			sb.append(num + " " + min + "\n");
		}
		else {
			min = Math.min(min, diameter[num]);
			dfs(after[num]);
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
					// TODO Auto-generated catch block
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
