import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static int n, a, b, c;
	static int visit[] = new int[4001];
	static int cache[] = new int[4001];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str[] = br.readLine().split(" ");
		
		n = Integer.parseInt(str[0]);
		a = Integer.parseInt(str[1]);
		b = Integer.parseInt(str[2]);
		c = Integer.parseInt(str[3]);
		
		System.out.print(dp(n));
	}
	
	static int dp(int i) {
		if(i < 0) {
			return -(1<<29);
		}
		else if(i == 0) {
			return 0;
		}
		else if(visit[i] != 0) {
			return cache[i];
		}
		else {
			visit[i] = i;
			cache[i] = 1 + Math.max(Math.max(dp(i-a), dp(i-b)), dp(i-c));
			return cache[i];
		}
	}

}
