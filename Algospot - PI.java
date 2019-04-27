import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int c, len, cache[];
	static char s[];
	static String str;
	
	public static void main(String[] args) {
		
		c = ss.nextInt();
		while(c-- > 0) {
			str   = ss.next();
			s     = str.toCharArray();
			len   = str.length();
			cache = new int[len];
			Arrays.fill(cache, -1);
			sb.append(dp(0) + "\n");
		}
		System.out.print(sb.toString());
	}
	
	static int dp(int index) {
		
		if(index == len)
			return 0;
		if(cache[index] != -1)
			return cache[index];
		cache[index] = 987654321;
		for(int i = 3; i <= 5; i++)
			if(index + i <= len)
				cache[index] = Math.min(cache[index], dp(index + i) + getLevel(index, index + i));
		return cache[index];
	}
	
	static int getLevel(int start, int end) {
		
		boolean L1 = true;
		for(int i = start; i < end-1; i++)
			if(s[i] != s[i+1])
				L1 = false;
		if(L1)
			return 1;
		boolean L2 = true;
		for(int i = start; i < end-1; i++)
			if(s[start] - s[start+1] != s[i] - s[i+1])
				L2 = false;
		if(L2 && Math.abs(s[start] - s[start+1]) == 1)
			return 2;
		boolean L4 = true;
		for(int i = start; i < end-2; i++)
			if(s[i] != s[i+2])
				L4 = false;
		if(L4)
			return 4;
		if(L2)
			return 5;
		return 10;
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
