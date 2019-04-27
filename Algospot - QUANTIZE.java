import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int c, n, s, num[], cache[][], pSum[], pSqSum[];
	static final int INF = 987654321;
	
	public static void main(String[] args) {
		
		c = ss.nextInt();
		while(c-- > 0) {
			n 	   = ss.nextInt();
			s 	   = ss.nextInt();
			num    = new int[n];
			pSum   = new int[n];
			pSqSum = new int[n];
			cache = new int[n][s+1];
			for(int i = 0; i < n; i++) {
				num[i] = ss.nextInt();
				Arrays.fill(cache[i], -1);
			}
			Arrays.sort(num);
			pSum[0] = num[0];
			pSqSum[0] = num[0] * num[0];
			for(int i = 1; i < n; i++) {
				pSum[i] = pSum[i-1] + num[i];
				pSqSum[i] = pSqSum[i-1] + num[i] * num[i];
			}
			sb.append(dp(0, s)+"\n");
		}
		System.out.print(sb.toString());
	}
	
	static int dp(int start, int parts) {
		
		if(start == n)
			return 0;
		if(parts == 0)
			return INF;
		if(cache[start][parts] != -1)
			return cache[start][parts];
		cache[start][parts] = INF;
		for(int size = 1; start + size <= n ; size++)
			cache[start][parts] = Math.min(
					cache[start][parts],
					minError(start, start + size - 1) + dp(start + size, parts - 1));
		return cache[start][parts];
	}
	
	static int getError(int start, int end) {
		
		int min = num[start];
		int max = num[end];
		int err = INF;
		for(int i = min; i <= max; i++) {
			int cand = 0;
			for(int j = start; j <= end; j++)
				cand += Math.pow(num[j] - i, 2);
			err = Math.min(err, cand);
		}
		return err;
	}
	
	static int minError(int lo, int hi) {
		
		double sum = pSum[hi] - (lo == 0 ? 0 : pSum[lo-1]);
		int sqSum = pSqSum[hi] - (lo == 0 ? 0 : pSqSum[lo-1]);
		int m = (int) ((sum / (hi - lo + 1)) + 0.5);
		int ret = (int) (sqSum - (2 * m * sum) + (m * m * (hi - lo +1)));
		return ret;
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
