import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) {
		
		FastScanner fs = new FastScanner();
		Long n = fs.nextInt();
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<n; i++) {
			long x = fs.nextInt();
			if(tPrimeTest(x)) {
				sb.append("YES\n");
			}
			else {
				sb.append("NO\n");
			}
		}
		System.out.print(sb.toString());
	}
	
	static boolean tPrimeTest(long x) {
		
		long root = (long) Math.sqrt(x);
		
		if(x == 1)
			return false;
		
		if(x == 4)
			return true;
		
		if(root != Math.sqrt(x))
			return false;
		
		if(root % 2 == 0)
			return false;
		
		if(!primeTest(root))
			return false;
		
		return true;
	}
	
	static boolean primeTest(long x) {
		if(x == 3)
			return true;
		if(x % 3 == 0)
			return false;
		int i=5, w=2;
		while(i*i<=x) {
			if(x%i == 0) {
				return false;
			}
			i += w;
			w = 6-w;
		}
		return true;
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
		
		Long nextInt() {
			return Long.parseUnsignedLong(next());
		}
	}

}
