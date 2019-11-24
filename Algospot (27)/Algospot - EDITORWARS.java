import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int c, n, m, msgNum;
	static int parent[], rank[], size[], enemy[];
	static boolean isError;
	
	public static void main(String[] args) {
		
		c = fs.nextInt();
		while(c-- > 0) {
			n       = fs.nextInt();
			m       = fs.nextInt();
			isError = false;
			parent  = new int[n]; for(int i = 0; i < n; i++) parent[i] = i;
			rank    = new int[n]; Arrays.fill(rank,   1);
			size    = new int[n]; Arrays.fill(size,   1);
			enemy   = new int[n]; Arrays.fill(enemy, -1);
			
			for(int i = 0; i < m; i++) {
				String msg = fs.next();
				int a = fs.nextInt();
				int b = fs.nextInt();
				if(isError)
					continue;
				if(msg.equals("ACK")) {
					if(!ack(a, b)) {
						msgNum = i;
						isError = true;
					}
				}
				else {
					if(!dis(a, b)) {
						msgNum = i;
						isError = true;
					}
				}
			}
			if(isError)
				sb.append("CONTRADICTION AT " + (msgNum + 1) + "\n");
			else
				sb.append("MAX PARTY SIZE IS " + getMax() + "\n");
		}
		System.out.print(sb.toString());
	}
	
	static int find(int a) {
		
		if(a == parent[a])
			return a;
		return parent[a] = find(parent[a]);
	}
	
	static int union(int a, int b) {
		
		if(a == -1 || b == -1)
			return Math.max(a, b);
		a = find(a);
		b = find(b);
		if(a == b)
			return a;
		if(rank[a] > rank[b]) {
			int temp = a;
			a = b;
			b = temp;
		}
		if(rank[a] == rank[b])
			rank[b]++;
		parent[a] = b;
		size[b] += size[a];
		return b;
	}
	
	static boolean ack(int a, int b) {
		
		a = find(a);
		b = find(b);
		if(a == enemy[b])
			return false;
		int A = union(a, b);
		int B = union(enemy[a], enemy[b]);
		enemy[A] = B;
		if(B != -1)
			enemy[B] = A;
		return true;
	}
	
	static boolean dis(int a, int b) {
		
		a = find(a);
		b = find(b);
		if(a == b)
			return false;
		union(a, enemy[b]);
		union(b, enemy[a]);
		int A = union(a, enemy[b]);
		int B = union(b, enemy[a]);
		enemy[A] = B;
		enemy[B] = A;
		return true;
	}
	
	static int getMax() {
		
		int sum = 0;
		for(int i = 0; i < n; i++) {
			if(i == parent[i]) {
				int e = enemy[i];
				if(e > i)
					continue;
				int size_i = size[i];
				int size_e = (e == -1 ? 0 : size[e]);
				sum += Math.max(size_i, size_e);
			}
		}
		return sum;
	}
	
	static FastScanner fs = new FastScanner();
	static StringBuilder sb = new StringBuilder();
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
	
}
