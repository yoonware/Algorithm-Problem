import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
	
	static int n, m, a, b, rNum, eNum[];
	static ArrayList<Integer> edge[];
	static boolean isPossible, isCat[];
	
    public static void main(String[] args) {
    	n = ss.nextInt();
    	m = ss.nextInt();
    	isPossible = false;
    	eNum = new int[n + 1];
    	edge = new ArrayList[n + 1];
    	isCat = new boolean[n + 1];
    	for(int i = 1; i <= n; i++)
    		edge[i] = new ArrayList<>();
    	for(int i = 1; i <= n; i++)
    		if(ss.nextInt() == 1)
    			isCat[i] = true;
    	for(int i = 1; i < n; i++) {
    		a = ss.nextInt();
    		b = ss.nextInt();
    		edge[a].add(b);
    		edge[b].add(a);
    		eNum[a]++;
    		eNum[b]++;
    	}
    	eNum[1] = -1;
    	dfs(0, 1, 0);
    	System.out.println(rNum);
    }
    
    static void dfs(int before, int node, int cNum) {
    	// 고양이가 있다면 연속된 고양이 수 추가
    	if(isCat[node])
    		cNum += 1;
    	// 고양이가 없다면 연속된 고양이 수 초기화
    	else
    		cNum = 0;
    	// 연속된 고양이가 제한된 수 보다 많을 때
    	if(cNum > m)
    		return;
    	// 현재 노드가 leaf 일 때
    	if(eNum[node] == 1) {
    		rNum++;
    		return;
    	}
    	// 현재 노드가 leaf 아닐 때
    	for(int i = 0; i < edge[node].size(); i++) {
    		int next = edge[node].get(i);
    		if(next != before)
    			dfs(node, edge[node].get(i), cNum);
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