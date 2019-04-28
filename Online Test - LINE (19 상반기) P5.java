import java.util.Scanner;

public class P5 {

	static int C, B, answer;
	static short cache[][];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		C = sc.nextInt();
		B = sc.nextInt();
		if(C == B) {
			answer = 0;
		}
		else {
			cache = new short[632][200001];
			answer = dp(C, B, 0);
			if(answer >= 632)
				answer = -1;
		}
		System.out.println(answer);
	}
	
	static short dp(int c, int b, int second) {
		
		if(second >= 632)
			return 10000;
		
		if(b < 0 || b > 200000)
			return 10000;
		
		if(cache[second][b] != 0)
			return cache[second][b];
		
		if(c == b)
			return cache[second][b] = 0;
		
		int s = second + 1;
		int d1 = dp(c + s, b - 1, s);
		int d2 = dp(c + s, b + 1, s);
		int d3 = dp(c + s, b * 2, s);
		return cache[second][b] = (short) (Math.min(d1, Math.min(d2, d3)) + 1);
	}

}