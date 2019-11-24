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
    	// �������(1) : ���� ����
    	if(x < 0 || x >= m || y < 0 || y >= n)
    		return;
    	// �������(2) : ������ ����
    	if(y == n - 1 && x == m - 1) {
    		min = Math.min(min, block);
    		return;
    	}
    	// �������(3) : �̹� üũ�� �� && �ֻ��� �䵵 �ƴ� ��)
    	if(cache[y][x] != -1 && block + map[y][x] >= cache[y][x])
    		return;
    	// ĳ�� ����
    	cache[y][x] = block + map[y][x];
    	// Ž��
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