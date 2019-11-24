import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
	
	static int n, init[], goal[], x, y;
	static ArrayList<Integer> node, edge[];
	
    public static void main(String[] args) {
    	
    	init = new int[100001];
    	goal = new int[100001];
    	node = new ArrayList<>();
    	edge = new ArrayList[100001];
    	for(int i = 0; i < 100001; i++)
    		edge[i] = new ArrayList<>();
    	
    	n = ss.nextInt();
    	for(int i = 1; i < n; i++) {
    		x = ss.nextInt();
    		y = ss.nextInt();
    		edge[x].add(y);
    		edge[y].add(x);
    	}
    	for(int i = 1; i <= n; i++)
    		init[i] = ss.nextInt();
    	for(int i = 1; i <= n; i++)
    		goal[i] = ss.nextInt();
    	
    	dfs(1, 0, 0, 0);
    	int length = node.size();
    	
    	sb.append(length + "\n");
    	for(int i = 0; i < length; i++)
    		sb.append(node.get(i) + "\n");
    	System.out.print(sb.toString());
    }
    
    static void dfs(int now, int from, int current, int sum) {
    	if((init[now] + sum) % 2 != goal[now]) {
    		current++;
    		sum++;
    		node.add(now);
    	}
    	sum += current;
    	int size = edge[now].size();
    	for(int i = 0; i < size; i++) {
    		int to = edge[now].get(i);
    		if(to == from)
    			continue;
    		dfs(to, now, current, sum);
    	}
    }
    
    static class StringScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    String str = br.readLine();
                    if (str == null)
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
    }

    static StringScanner ss = new StringScanner();
    static StringBuilder sb = new StringBuilder();

}