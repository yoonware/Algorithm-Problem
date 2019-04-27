import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
	
	static int n, m;
	static ArrayList<Double> q, p;

	public static void main(String[] args) {
		n = ss.nextInt();
		m = ss.nextInt();
		q = new ArrayList<>();
		p = new ArrayList<>();
		for (int i = 0; i < m; i++)
			q.add(ss.nextDouble());
		m = ss.nextInt();
		for (int i = 0; i < m; i++)
			p.add(ss.nextDouble());
		for(int i = m - 1; i >= 0; i--)
		{
			if(p.get(i) <= 0) {
				p.remove(i);
				q.remove(i);
			}
		}
		if(q.size() == 1)
		{
			System.out.println(p.get(0));
			return;
		}
		int a = -5, b = -5;
		for(int i = 0; i < q.size(); i++)
		{
			if(q.get(i) == n)
			{
				System.out.println(p.get(i));
				return;
			}
			if(q.get(i) > n)
			{
				a = i - 1;
				b = i;
				break;
			}
		}
		if(a == -5 && b == -5)
		{
			a = p.size() - 2;
			b = p.size() - 1;
		}
		if(b == 0)
		{
			a = 0;
			b = 1;
		}
		double dx = q.get(b) - q.get(a);
		double move = n - q.get(b);
		double result = p.get(b) + (p.get(b) - p.get(a)) * (move / dx);
		System.out.println(Math.round(result * 100) / 100.0);
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
		double nextDouble() {
			return Double.parseDouble(next());
		}
	}
	
	static StringScanner ss = new StringScanner();
	static StringBuilder sb = new StringBuilder();
}
