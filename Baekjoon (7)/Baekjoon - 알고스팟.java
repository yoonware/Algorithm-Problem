import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int n, m, min, map[][], cache[][];
	
    public static void main(String[] args) {
    	m = ss.nextInt();
    	n = ss.nextInt();
    	min = 2000;
    	map = new int[n][m];
    	cache = new int[n][m];
    	for(int i = 0; i < n; i++) {
    		String str = ss.next();
    		for(int j = 0; j < m; j++) {
    			map[i][j] = str.charAt(j) - '0';
    			cache[i][j] = -1;
    		}
    	}
    	search(0, 0, 0);
    	System.out.println(min);
    }
    
    static void search(int x, int y, int block) {
    	// 기저사례(1) : 범위 오류
    	if(x < 0 || x >= m || y < 0 || y >= n)
    		return;
    	// 기저사례(2) : 도착지 도착
    	if(y == n - 1 && x == m - 1) {
    		min = Math.min(min, block);
    		return;
    	}
    	// 기저사례(3) : 이미 체크한 곳 && 최상의 답도 아닌 곳)
    	if(cache[y][x] != -1 && block + map[y][x] >= cache[y][x])
    		return;
    	// 캐시 갱신
    	cache[y][x] = block + map[y][x];
    	// 탐색
    	search(x + 1, y, cache[y][x]);
    	search(x - 1, y, cache[y][x]);
    	search(x, y + 1, cache[y][x]);
    	search(x, y - 1, cache[y][x]);
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