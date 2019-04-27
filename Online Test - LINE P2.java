import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2 {

	public static void main(String[] args) {
		
		String str = ss.next();
		int numA = 0, numB = 0, wp = 0, np = -1;
		
		for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') {
				if(str.charAt(i+1) >= 'a' && str.charAt(i+1) <= 'z')
					i++;
				numA++;
			}
			if(str.charAt(i) == '1') {
				if(np == -1)
					np = i;
				if(i+1 < str.length() && str.charAt(i+1) == '0')
					i++;
				numB++;
			}
			if(str.charAt(i) >= '2' && str.charAt(i) <= '9') {
				if(np == -1)
					np = i;
				if(i+1 < str.length() && str.charAt(i+1) == '0') {
					System.out.print("error");
					return;
				}
				numB++;
			}
		}
		
		if(numA != numB) {
			System.out.print("error");
			return;
		}
		
		for(int i = 0; i < numA; i++) {
			sb.append(str.charAt(wp));
			if(str.charAt(wp+1) >= 'a' && str.charAt(wp+1) <= 'z') {
				sb.append(str.charAt(wp+1));
				wp += 2;
			}
			else {
				wp++;
			}
			if(str.charAt(np) == '1') {
				if(np+1 < str.length() && str.charAt(np+1) == '0') {
					sb.append("10");
					np += 2;
				}
				else {
					np++;
				}
			}
			else {
				sb.append(str.charAt(np));
				np++;
			}
		}
		System.out.print(sb.toString());
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