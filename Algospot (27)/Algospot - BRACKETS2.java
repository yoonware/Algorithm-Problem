import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	
	static String str;
	static ArrayList<Character> stack;

	public static void main(String[] args) {

		int tc = ss.nextInt();
		while (tc-- > 0) {
			str = ss.next();
			stack = new ArrayList<>();
			if (isStrValid()) sb.append("YES\n");
			else sb.append("NO\n");
		}
		System.out.print(sb.toString());
	}
	
	static boolean isStrValid() {
		for(int i = 0; i < str.length(); i++) {
			char c1 = str.charAt(i);
			if(c1 == '(' || c1 == '{' || c1 == '[') stack.add(c1);
			else {
				if(stack.isEmpty()) return false;
				char c2 = stack.remove(stack.size()-1);
				if(c1 == ')' && c2 != '(') return false;
				if(c1 == '}' && c2 != '{') return false;
				if(c1 == ']' && c2 != '[') return false;
			}
		}
		return stack.isEmpty();
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
