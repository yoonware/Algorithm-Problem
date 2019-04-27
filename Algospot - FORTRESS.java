import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
	
	static int C, N;
	static ArrayList<Node> tree;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder  sb = new StringBuilder();
		C = Integer.parseInt(br.readLine().trim());
		
		while(C-- > 0) {
			
			N = Integer.parseInt(br.readLine().trim());
			tree = new ArrayList<>();
			
			for(int i=0; i<N; i++) {
				String xyr[] = br.readLine().split(" ");
				tree.add(new Node(Integer.parseInt(xyr[0]), Integer.parseInt(xyr[1]), Integer.parseInt(xyr[2])));
			}
			initTree();
			
			int root_leaf = getLength(N-1, 0, 0)[0];
			int leaf_leaf = 0;
			for(int i=0; i<N; i++) {
				int length[] = getLength(i, 0, 0);
				leaf_leaf = Math.max(leaf_leaf, length[0] + length[1]);
			}
			
			sb.append(Math.max(root_leaf, leaf_leaf));
			sb.append("\n");
		}
		
		System.out.print(sb.toString());
		return;
	}
	
	static void initTree() {
		
		Collections.sort(tree);
		for(int i=0; i<tree.size(); i++) {
			for(int j=i+1; j<tree.size(); j++) {
				Node a = tree.get(i);
				Node b = tree.get(j);
				int distance = (a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y);
				if(distance < (b.r * b.r)) {
					b.child.add(i);
					break;
				}
			}
		}
	}
	
	static int[] getLength(int nodeNumber, int deep_1, int deep_2) {
		
		int max[] = {deep_1, deep_2};
		ArrayList<Integer> child = tree.get(nodeNumber).child;
		for(int i=0; i<child.size(); i++) {
			max[1] = Math.max(max[1], getLength(child.get(i), deep_1 + 1, deep_2 + 1)[0]);
			if(max[1] > max[0]) {
				int save = max[1];
				max[1] = max[0];
				max[0] = save;
			}
		}
		return max;
	}
}

class Node implements Comparable<Node>{
	
	int x, y, r;
	ArrayList<Integer> child;
	
	Node(int _x, int _y, int _r) {
		
		x = _x;
		y = _y;
		r = _r;
		child  = new ArrayList<>();
	}

	@Override
	public int compareTo(Node next) {
		
		return ((Integer) r).compareTo((Integer) next.r); 
	}
}
