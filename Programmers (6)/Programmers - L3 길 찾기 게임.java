import java.util.ArrayList;
import java.util.Collections;

class Pair implements Comparable<Pair>{
	int x, y;
	int node, left, right;
	Pair(int a, int b, int c) {
		x = a;
		y = b;
		node = c;
		left = -1;
		right = -1;
	}
	@Override
	public int compareTo(Pair o) {
		if(this.y < o.y)
			return 1;
		if(this.y == o.y && this.x > o.x)
			return 1;
		if(this.y == o.y && this.x == o.x)
			return 0;
		return -1;
	}
}

public class Solution {
	
	static int nodeinfo[][] = {{5, 3}, {11, 5}, {13, 3}, {3, 5}, {6, 1}, {1, 3}, {8, 6}, {7, 2}, {2, 2}};
	static ArrayList<Pair> tree;
	static int size, pre, post, answer[][];
	
	public static void main(String[] args) {
		
		size = nodeinfo.length;
		tree = new ArrayList<Pair>();
		answer = new int[2][size];
		for(int i = 0; i < size; i++)
			tree.add(new Pair(nodeinfo[i][0], nodeinfo[i][1], i + 1));
		Collections.sort(tree);
		makeTree(0, 0, 100000);
		pre = 0;
		preOrder(0);
		post = 0;
		postOrder(0);
		for(int i = 0; i < size; i++)
			System.out.print(answer[0][i] + " ");
		System.out.println();
		for(int i = 0; i < size; i++)
			System.out.print(answer[1][i] + " ");
	}
	
	static void preOrder(int index) {
		answer[0][pre] = tree.get(index).node;
		pre++;
		if(tree.get(index).left != -1)
			preOrder(tree.get(index).left);
		if(tree.get(index).right != -1)
			preOrder(tree.get(index).right);
	}
	
	static void postOrder(int index) {
		if(tree.get(index).left != -1)
			postOrder(tree.get(index).left);
		if(tree.get(index).right != -1)
			postOrder(tree.get(index).right);
		answer[1][post] = tree.get(index).node;
		post++;
	}
	
	static void makeTree(int num, int left, int right) {
		int px = tree.get(num).x;
		int py = tree.get(num).y;
		boolean L = false, R = false;
		for(int i = num + 1; i < size; i++) {
			int nx = tree.get(i).x;
			int ny = tree.get(i).y;
			if(ny >= py)
				continue;
			if(!L && left <= nx && nx <= px - 1) {
				tree.get(num).left = i;
				L = true;
				makeTree(i, left, px - 1);
				continue;
			}
			if(!R && px + 1 <= nx && nx <= right) {
				tree.get(num).right = i;
				R = true;
				makeTree(i, px + 1, right);
				continue;
			}
			if(L && R)
				break;
		}
	}
	
}