import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int n;
	static long h, min, minutes;
	static long d[], psum[];
	static boolean isInf = false;
	
    public static void main(String[] args) {
    	h = ss.nextLong();
    	n = ss.nextInt();
    	d = new long[n + 1];
    	psum = new long[n + 1];
    	for(int i = 1; i <= n; i++) {
    		d[i] = ss.nextLong();
    		psum[i] = psum[i - 1] + d[i];
    		min = Math.min(min, psum[i]);
    	}
    	// ���Ѽ� üũ (ù �������� ������ ���� �� && �κ��� ������ ���� ��� �� ��)
    	if(h + min > 0 && psum[n] >= 0)
    		minutes = -1;
    	else {
    		// ������ ���� �������� ����
    		if(h + min > 0) {
    			minutes = ((h + min - 1) / (-psum[n]) + 1) * n;
    			h += psum[n] * (minutes / n);
    		}
    		// ������ �������� ������ ���� �˻�
    		for(int i = 1; i <= n; i++)
    			if(h + psum[i] <= 0) {
    				minutes += i;
    				break;
    			}
    	}
    	System.out.println(minutes);
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
        long nextLong() {
            return Long.parseLong(next());
        }
    }

    static StringScanner ss = new StringScanner();
    static StringBuilder sb = new StringBuilder();
    
}