import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static FastScanner fs = new FastScanner();
	static int g, n, taxi, group[];

	public static void main(String[] args) {
		
		n      = fs.nextInt();
		g      = n;
		taxi   = 0;
		group  = new int[5];
		for(int i = 0; i < n; i++) {
			group[fs.nextInt()]++;
		}
		// 4	
		taxi += group[4];
		group[4] = 0;
		taxi += Math.min(group[1], group[3]);
		if(group[1] > group[3]) {
			group[1] -= group[3];
			group[3] = 0;
		}
		else {
			group[3] -= group[1];
			group[1] = 0;
		}
		taxi += group[2] / 2;
		group[2] = group[2] % 2;
		taxi += group[1] / 4;
		group[1] = group[1] % 4;
		if(group[1] == group[2] * 2) {
			taxi += group[2];
			group[1] = 0;
			group[2] = 0;
		}
		else if(group[1] > group[2] * 2) {
			taxi += group[2];
			group[1] -= (group[2] * 2);
			group[2] = 0;
		}
		else if(group[1] < group[2] * 2) {
			taxi += group[1] / 2;
			group[2] -= (group[1] / 2);
			group[1] = group[1] % 2;
		}
		// 3
		taxi += group[3];	
		taxi += Math.min(group[1], group[2]);
		if(group[1] > group[2]) {
			group[1] -= group[2];
			group[2] = 0;
		}
		else {
			group[2] -= group[1];
			group[1] = 0;
		}
		taxi += group[1] / 3;
		group[1] = group[1] % 3;
		// 2	
		taxi += group[2];
		taxi += group[1] / 2;
		group[1] = group[1] % 2;
		// 1
		taxi += group[1];
		// 답
		System.out.print(taxi);
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
