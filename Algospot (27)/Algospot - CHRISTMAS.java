import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	static int N, K;

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();

		while(T-- > 0) {
			N = scan.nextInt();		// 상자의 개수
			K = scan.nextInt();		// 어린이의 수
			
			int D[]    = new int[N+1];	D[0]    = 0;
			int psum[] = new int[N+1];	psum[0] = 0;
			
			// 각 상자의 인형 개수
			for(int i=1; i<N+1; i++) {
				D[i] = scan.nextInt();
			}
			
			// 부분 합
			for(int i=1; i<N+1; i++) {
				psum[i] = (psum[i-1] + D[i]) % K;
			}
			
			solve_1(psum);
			solve_2(psum);
		}
		
		scan.close();
	}
	
	static void solve_1(int[] psum) {
		
		long count = 0;
		long mod[] = new long[K];
		
		for(int i=0; i<N+1; i++) {
			mod[psum[i]]++;
		}
		
		for(int i=0; i<K; i++) {
			if(mod[i] >= 2) {
				count = (count + (mod[i] * (mod[i]-1)) / 2) % 20091101;
			}
		}
		
		System.out.print(count + " ");
	}
	
	static void solve_2(int[] psum) {
		
		int dp[]   = new int[N+1];
		int memo[] = new int[K];
		
		Arrays.fill(memo, -1);
		dp[0] = 0;
		memo[psum[0]] = 0;
		
		for(int i=1; i<N+1; i++) {
			dp[i] = dp[i-1];
			if(memo[psum[i]] != -1) {
				dp[i] = Math.max(dp[i], dp[memo[psum[i]]] + 1);
			}
			memo[psum[i]] = i;
		}
		
		System.out.println(dp[N]);
	}
	
}
