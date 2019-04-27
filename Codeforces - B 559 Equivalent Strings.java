import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) {
		
		String a = ss.next();
		String b = ss.next();
		if(sort(a).equals(sort(b))) System.out.print("YES");
		else					    System.out.print("NO");
	}
	
	static String sort(String a) {
		int end = a.length();
		int mid = end/2;
		if(end % 2 == 1)    		return a;
		String a1 = sort(a.substring(0, mid));
		String a2 = sort(a.substring(mid, end));
		if(a1.compareTo(a2) < 0) 	return a1 + a2;
		else                     	return a2 + a1;
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
