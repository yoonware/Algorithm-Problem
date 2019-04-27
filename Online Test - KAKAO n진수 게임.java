import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution {

	static int n, t, m, p, now, num, index;
	static ArrayList<Integer> answer, temp;
	
	public static void main(String[] args) {
		n = ss.nextInt();
		t = ss.nextInt();
		m = ss.nextInt();
		p = ss.nextInt();
		answer = new ArrayList<>();
		temp = new ArrayList<>();
		now = 0;
		while(true) {
			num = now;
			temp.clear();
			while(num >= n) {
				temp.add(num % n);
				num /= n;
			}
			temp.add(num);
			now++;
			Collections.reverse(temp);
			for(int i = 0; i < temp.size(); i++)
				answer.add(temp.get(i));
			if(answer.size() > t * m)
				break;
		}
		index = p - 1;
		while(index < t * m)
		{
			num = answer.get(index);
			if(num >= 10) {
				char c = (char) (num - 10 + 'A');
				sb.append(c);
			}
			else
				sb.append(answer.get(index));
			index += m;
		}
		System.out.println(sb.toString());
	}
	
	
	static class StringScanner {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String next() {
			while(st == null || !st.hasMoreTokens()) {
				try {
					String str = br.readLine();
					if(str == null)
						return null;
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
		double nextDouble() {
			return Double.parseDouble(next());
		}
	}
	
	static StringScanner ss = new StringScanner();
	static StringBuilder sb = new StringBuilder();
	
}