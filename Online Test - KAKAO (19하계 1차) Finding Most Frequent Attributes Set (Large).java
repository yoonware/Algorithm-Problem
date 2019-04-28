import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Solution {

	static int pick, row, index[];
	static double threshold;
	static String line[][], sub;
	static final int size = 12;
	static HashMap<String, Integer> map;
	static Iterator<String> keys;
	
	public static void main(String[] args) {
		pick = ss.nextInt();
		threshold = ss.nextDouble();
		row = ss.nextInt();
		threshold *= (double) row;
		index = new int[pick];
		line = new String[row][size];
		map = new HashMap<>();
		for(int i = 0; i < row; i++) {
			String[] str = ss.next().split(",");
			for(int j = 0; j < size; j++)
				line[i][j] = str[j];
		}
		for(int i = 0; i < size; i++)
			combination(i, 0);
		System.out.println(sb.toString());
	}
	
	static void search() {
		map.clear();
		for(int i = 0; i < row; i++) {
			sub = "";
			for(int j = 0; j < pick; j++) {
				sub += line[i][index[j]] + ",";
			}
			if(map.containsKey(sub))
				map.replace(sub, map.get(sub) + 1);
			else
				map.put(sub, 1);
		}
		keys = map.keySet().iterator();
		while(keys.hasNext()) {
			sub = keys.next();
			if(map.get(sub) > threshold)
				sb.append(sub.substring(0, sub.length() - 1) + "\n");
		}
	}
	
	static void combination(int now, int count) {
		index[count++] = now;
		if(count == pick) {
			search();
			return;
		}
		for(int i = now + 1; i < size; i++)
			combination(i, count);
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