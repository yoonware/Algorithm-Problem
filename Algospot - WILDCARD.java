import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static int c, n, wLen, fLen;
	static String w, f;
	static boolean isPossible;
	static PriorityQueue<String> pq;

	public static void main(String[] args) {
		
		c = ss.nextInt();
		while(c-- > 0) {
			w = ss.next();
			n = ss.nextInt();
			pq = new PriorityQueue<String>();
			for(int i = 0; i < n; i++) {
				f          = ss.next();
				isPossible = false;
				wLen       = w.length() - 1;
				fLen       = f.length() - 1;
				dp(0, 0);
				if(isPossible)
					pq.offer(f);
			}
			while(!pq.isEmpty()) {
				sb.append(pq.poll() + "\n");
			}
		}
		System.out.print(sb.toString());
	}
	
	static void dp(int wp, int fp) {
		
		if(wp == wLen) {
			if(w.charAt(wp) == '*') {
				isPossible = true;
				return;
			}
			if(fp == fLen) {
				if(w.charAt(wp) == '?') {
					isPossible = true;
					return;
				}
				else if(w.charAt(wp) == f.charAt(fp)) {
					isPossible = true;
					return;
				}
				else {
					return;
				}
			}
		}
		
		if(wp > wLen || fp > fLen)
			return;
		
		if(w.charAt(wp) == '?')
			dp(wp + 1, fp + 1);
		else if(w.charAt(wp) == '*')
			for(int i = fp; i < f.length(); i++)
				dp(wp + 1, i);
		else {
			if(w.charAt(wp) == f.charAt(fp))
				dp(wp + 1, fp + 1);
			else
				return;
		}
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
