import java.util.Scanner;

public class Main {
	
	static final int LIMIT_MAX =  100000;
	static final int LIMIT_MIN = -100000;
	
	static int N, Q;
	static int h[], a[], b[];
	static int minTree[], maxTree[];

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int C = scan.nextInt();
		
		while(C-- > 0) {
			
			// 표지판의 수(N), 등산로의 수(Q)
			N = scan.nextInt();
			Q = scan.nextInt();
			
			// 각 표지판의 해발 고도(h[0] ~ h[N-1])
			h = new int[N];
			for(int i=0; i<N; i++) {
				h[i] = scan.nextInt();
			}
			
			// 등산로의 첫 표지판(a[0] ~ a[Q-1]), 마지막 표지판(b[0] ~ b[Q-1])
			a = new int[Q];
			b = new int[Q];
			for(int i=0; i<Q; i++) {
				a[i] = scan.nextInt();
				b[i] = scan.nextInt();
			}
			
			// 구간트리 초기화(최소 값)
			minTree = new int[N * 4];
			min_init(0, N-1, 1);
			
			// 구간 트리 초기화(최대 값)
			maxTree = new int[N * 4];
			max_init(0, N-1, 1);
			
			// 구간 트리 질의 처리
			for(int i=0; i<Q; i++) {
				int min = min_query(a[i], b[i], 1, 0, N-1);
				int max = max_query(a[i], b[i], 1, 0, N-1);
				System.out.println(max - min);
			}
		}
		
		scan.close();
	}
	
	static int min_init(int left, int right, int node) {
		if(left == right) {
			return minTree[node] = h[left];
		}
		int mid = (left + right) / 2;
		int leftMin = min_init(left, mid, node * 2);
		int rightMin = min_init(mid+1, right, node * 2 + 1);
		return minTree[node] = Math.min(leftMin, rightMin);
	}
	
	static int max_init(int left, int right, int node) {
		if(left == right) {
			return maxTree[node] = h[left];
		}
		int mid = (left + right) / 2;
		int leftMin = max_init(left, mid, node * 2);
		int rightMin = max_init(mid+1, right, node * 2 + 1);
		return maxTree[node] = Math.max(leftMin, rightMin);
	}
	
	static int min_query(int left, int right, int node, int nodeLeft, int nodeRight) {
		if(right < nodeLeft || nodeRight < left) {
			return LIMIT_MAX;
		}
		if(left <= nodeLeft && nodeRight <= right) {
			return minTree[node];
		}
		int mid = (nodeLeft + nodeRight) / 2;
		return Math.min(min_query(left, right, node*2, nodeLeft, mid),
				        min_query(left, right, node*2+1, mid+1, nodeRight));
	}
	
	static int max_query(int left, int right, int node, int nodeLeft, int nodeRight) {
		if(right < nodeLeft || nodeRight < left) {
			return LIMIT_MIN;
		}
		if(left <= nodeLeft && nodeRight <= right) {
			return maxTree[node];
		}
		int mid = (nodeLeft + nodeRight) / 2;
		return Math.max(max_query(left, right, node*2, nodeLeft, mid),
				        max_query(left, right, node*2+1, mid+1, nodeRight));
	}
	
}
