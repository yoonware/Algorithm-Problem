import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class P3 {
	
	static int n1, n2;
	static ArrayList<String> head1, head2;
	static ArrayList<Integer> array;
	static HashMap<Integer, Pair> map1, map2;
	
	static class Pair {
		String s1, s2;
		Pair(String s_1, String s_2) {
			s1 = s_1;
			s2 = s_2;
		}
	}
	
	public static void main(String[] args) {
		
		head1 = new ArrayList<>();
		head2 = new ArrayList<>();
		array = new ArrayList<>();
		map1  = new HashMap<>();
		map2  = new HashMap<>();
		
		n1 = ss.nextInt();
		head1.add(ss.next());
		head1.add(ss.next());
		head1.add(ss.next());
		for (int i = 0; i < n1 - 1; i++) {
			int a = ss.nextInt();
			String s1, s2;
			s1 = ss.next();
			s2 = ss.next();
			map1.put(a, new Pair(s1, s2));
			array.add(a);
		}
		
		n2 = ss.nextInt();
		head2.add(ss.next());
		head2.add(ss.next());
		head2.add(ss.next());
		for (int i = 0; i < n2 - 1; i++) {
			int a = ss.nextInt();
			String s1, s2;
			s1 = ss.next();
			s2 = ss.next();
			map2.put(a, new Pair(s1, s2));
		}
		
		Collections.sort(array);
		
		sb.append(head1.get(0) + " " + head1.get(1) + " " + head1.get(2) + " ");
		sb.append(head2.get(1) + " " + head2.get(2) + "\n");
		for (int i = 0; i < array.size(); i++) {
			sb.append(array.get(i) + " " + map1.get(array.get(i)).s1 + " " + map1.get(array.get(i)).s2 + " ");
			if(!map2.containsKey(array.get(i)))
				sb.append("NULL NULL\n");
			else
				sb.append(map2.get(array.get(i)).s1 + " " + map2.get(array.get(i)).s2 + "\n");
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