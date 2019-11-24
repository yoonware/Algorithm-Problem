import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int t, n, m;
	static double dist[];
	static PriorityQueue<Pair> pq;
	static ArrayList<ArrayList<Pair>> adj;
	static final double INF = -1;
	
	public static void main(String[] args) {

		t = fs.nextInt();
		while(t-- > 0) {
			// 컴퓨터의 수, 회선의 수
			n = fs.nextInt();
			m = fs.nextInt();
			// 인접 리스트 생성 및 입력
			adj = new ArrayList<>();
			for(int i = 0; i < n; i++)
				adj.add(new ArrayList<Pair>());
			for(int i = 0; i < m; i++) {
				int v1 = fs.nextInt();
				int v2 = fs.nextInt();
				double w = fs.nextDouble();
				adj.get(v1).add(new Pair(v2, w));
				adj.get(v2).add(new Pair(v1, w));
			}
			// 다익스트라
			dijkstra();
			sb.append(String.format("%.10f", dist[n-1]) + "\n");
		}
		System.out.print(sb.toString());
	}
	 
	static void dijkstra() {
		
		// 배열, 우선순위 큐 초기화
		dist = new double[n];
		pq   = new PriorityQueue<Pair>();
		Arrays.fill(dist, INF);
		dist[0] = 1;
		pq.offer(new Pair(0, 1));
		// 탐색
		while(!pq.isEmpty()) {
			// 첫 원소 추출 및 제거 (가장 가까운 정점)
			int    here = pq.peek().vertex;
			double cost = pq.peek().weight;
			pq.poll();
			// 이미 더 짧은 경로를 알고 있다면 무시
			if(dist[here] < cost)
				continue;
			// 인접한 모든 정점 검사
			for(int i = 0; i < adj.get(here).size(); i++) {
				int    next = adj.get(here).get(i).vertex;
				double cand = adj.get(here).get(i).weight * cost;
				if(dist[next] > cand || dist[next] == -1) {
					dist[next] = cand;
					pq.offer(new Pair(next, cand));
				}
			}
		}
	}
	
	static class Pair implements Comparable<Pair>{
		
		int    vertex;
		double weight;
		Pair(int v, double w) {
			vertex = v;
			weight = w;
		}
		@Override
		public int compareTo(Pair next) {
			return this.weight < next.weight ? -1 : 1;
		}
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
