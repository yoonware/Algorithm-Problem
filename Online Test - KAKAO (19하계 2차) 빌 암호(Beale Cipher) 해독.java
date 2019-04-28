import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    static int t, n, m, k, limit, answer;
    static int A[][], C[][], R[][], B[][], r[], Cr[], AxBr[];
    static boolean isAns;

    public static void main(String[] args) {
        t = ss.nextInt();
        
        while (t-- > 0) {
            n = ss.nextInt();
            m = ss.nextInt();
            k = ss.nextInt();
            A = new int[k][k];
            C = new int[k][k];
            R = new int[n][m];
            B = new int[k][k];
            r = new int[k];
            Cr = new int[k];
            AxBr = new int[k];
            
            for (int i = 0; i < k; i++)
                for (int j = 0; j < k; j++)
                    A[i][j] = ss.nextInt();
            for (int i = 0; i < k; i++)
                for (int j = 0; j < k; j++)
                    C[i][j] = ss.nextInt();
            for (int i = 0; i < n; i++)
                for (int j = 0; j < m; j++)
                    R[i][j] = ss.nextInt();
            
            answer = 0;
            
            for (int i = 0; i < n - k + 1; i++) {
                for (int j = 0; j < m - k + 1; j++) {
                    for (int col = i; col < i + k; col++)
                        for (int row = j; row < j + k; row++)
                            B[col - i][row - j] = R[col][row];
                    limit = 0;
                    isAns = false;
                    while (limit < 10) {
                        for (int s = 0; s < k; s++)
                            r[s] = (Math.random() < 0.5) ? 0 : 1;
                        Cr = makeCr();
                        AxBr = makeAxBr();
                        if (!java.util.Arrays.equals(Cr, AxBr)) {
                           isAns = false;
                            break;
                        }
                        else
                           isAns = true;
                        limit++;
                    }
                    if (isAns)
                        answer++;
                }
            }
            sb.append(answer + "\n");
        }
        System.out.print(sb.toString());
    }
    
    static int[] makeCr() {
       int[] ret = new int[k];
        for (int i = 0; i < k; i++)
           for (int j = 0; j < k; j++)
              ret[i] += r[j] * C[i][j];
        return ret;
    }

    static int[] makeAxBr() {
       int[] Br = new int[k];
        for (int i = 0; i < k; i++)
           for (int j = 0; j < k; j++)
              Br[i] += r[j] * B[i][j];
        int[] ret = new int[k];
        for (int i = 0; i < k; i++)
           for (int j = 0; j < k; j++)
              ret[i] += Br[j] * A[i][j];
        return ret;
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