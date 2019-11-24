import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static int tc, tn, n, map[][];
	static int numProc, numConnectedProc, numMaxProc, numMinLine;
	
	public static void main(String[] args) {
		tc = ss.nextInt();
		for(int tn = 1; tn <= tc; tn++) {
			n = ss.nextInt();
			map = new int[n][n];
			numProc = 0;
			numConnectedProc = 0;
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					map[i][j] = ss.nextInt();
					if(map[i][j] == 1) {
						numProc++;
						if(i == 0 || j == 0 || i == n - 1 || j == n - 1) {
							map[i][j] = 2;
							numConnectedProc++;
						}
					}
				}
			}
			numMaxProc = numConnectedProc;
			numMinLine = 0;
			dfs(0, 0, numConnectedProc);
			sb.append("#" + tn + " " + numMinLine + "\n");
		}
		System.out.print(sb.toString());
	}
	
	static void dfs(int y, int x, int count) {
		if(count == numProc) {
			updateLine(count);
			return;
		}
		boolean isChanged = false;
		for(int j = x + 1; j < n; j++) {
			if(map[y][j] == 1) {
				if(checkUp(y, j)) {
					isChanged = true;
					changeUp(y, j, 5); dfs(y, j, count + 1); changeUp(y, j, 0);
				}
				if(checkDn(y, j)) {
					isChanged = true;
					changeDn(y, j, 5); dfs(y, j, count + 1); changeDn(y, j, 0);
				}
				if(checkRi(y, j)) {
					isChanged = true;
					changeRi(y, j, 5); dfs(y, j, count + 1); changeRi(y, j, 0);
				}
				if(checkLe(y, j)) {
					isChanged = true;
					changeLe(y, j, 5); dfs(y, j, count + 1); changeLe(y, j, 0);
				}
				if(isChanged)
					return;
			}
		}
		for(int i = y + 1; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(map[i][j] == 1) {
					if(checkUp(i, j)) {
						isChanged = true;
						changeUp(i, j, 5); dfs(i, j, count + 1); changeUp(i, j, 0);
					}
					if(checkDn(i, j)) {
						isChanged = true;
						changeDn(i, j, 5); dfs(i, j, count + 1); changeDn(i, j, 0);
					}
					if(checkRi(i, j)) {
						isChanged = true;
						changeRi(i, j, 5); dfs(i, j, count + 1); changeRi(i, j, 0);
					}
					if(checkLe(i, j)) {
						isChanged = true;
						changeLe(i, j, 5); dfs(i, j, count + 1); changeLe(i, j, 0);
					}
					if(isChanged)
						return;
				}
			}
		}
		updateLine(count);
		return;
	}
	
	static void updateLine(int count) {
		if(numMaxProc < count) {
			numMaxProc = count;
			numMinLine = getLine();
		}
		else if(numMaxProc == count)
			numMinLine = Math.min(numMinLine, getLine());
	}
	
	static int getLine() {
		int ret = 0;
		for(int i = 0; i < n; i++)
			for(int j = 0; j < n; j++)
				if(map[i][j] == 5) 
					ret++;
		return ret;
	}
	
	static boolean checkUp(int y, int x) {
		for(int i = y - 1; i >= 0; i--)
			if(map[i][x] != 0)
				return false;
		return true;
	}
	
	static boolean checkDn(int y, int x) {
		for(int i = y + 1; i < n; i++)
			if(map[i][x] != 0)
				return false;
		return true;
	}
	
	static boolean checkRi(int y, int x) {
		for(int j = x + 1; j < n; j++)
			if(map[y][j] != 0)
				return false;
		return true;
	}
	
	static boolean checkLe(int y, int x) {
		for(int j = x - 1; j >= 0; j--)
			if(map[y][j] != 0)
				return false;
		return true;
	}
	
	static void changeUp(int y, int x, int v) {
		for(int i = y - 1; i >= 0; i--) map[i][x] = v;
	}
	
	static void changeDn(int y, int x, int v) {
		for(int i = y + 1; i < n; i++) map[i][x] = v;
	}
	
	static void changeRi(int y, int x, int v) {
		for(int j = x + 1; j < n; j++) map[y][j] = v;
	}
	
	static void changeLe(int y, int x, int v) {
		for(int j = x - 1; j >= 0; j--) map[y][j] = v;
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