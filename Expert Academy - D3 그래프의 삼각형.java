import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
	
	static int tc, tn, n, m, a, b, answer;
	static ArrayList<Integer> edge[];
	
    public static void main(String[] args) {
    	
    	tc = ss.nextInt();
    	while(tn++ < tc) {
    		n = ss.nextInt();
    		m = ss.nextInt();
    		answer = 0;
    		edge = new ArrayList[51];
    		for(int i = 1; i <= 50; i++)
    			edge[i] = new ArrayList<>();
    		for(int i = 1; i <= m; i++) {
    			a = ss.nextInt();
    			b = ss.nextInt();
    			edge[a].add(b);
    			edge[b].add(a);
    		}
    		for(int i = 1; i <= n; i++)
    			dfsAll(i);
    		sb.append("#" + tn + " " + answer / 6 + "\n");
    	}
    	System.out.print(sb.toString());
    }
    
    static void dfsAll(int now) {
    	int size = edge[now].size();
    	for(int i = 0; i < size; i++)
    		dfs(edge[now].get(i), now, 1, now);
    }
    
    static void dfs(int now, int from, int count, int destination) {
    	if(count == 3) {
    		if(now == destination)
    			answer++;
    		return;
    	}
    	int size = edge[now].size();
    	for(int i = 0; i < size; i++) {
    		int to = edge[now].get(i);
    		if(to == from)
    			continue;
    		dfs(edge[now].get(i), now, count + 1, destination);
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