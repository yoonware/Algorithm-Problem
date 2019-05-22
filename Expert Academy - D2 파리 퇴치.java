import java.util.Scanner;

public class Solution {
	
	static Scanner sc = new Scanner(System.in);
	static int tc, tn, n, m, map[][];
	
    public static void main(String[] args) {
    	tc = sc.nextInt();
    	while(tn++ < tc) {
    		n = sc.nextInt();
    		m = sc.nextInt();
    		map = new int[n][n];
    		for(int i = 0; i < n; i++)
    			for(int j = 0; j < n; j++)
    				map[i][j] = sc.nextInt();
    		int max = 0;
    		for(int i = 0; i < n - m + 1; i++)
    			for(int j = 0; j < n - m + 1; j++) {
    				int sum = 0;
    				for(int col = 0; col < m; col++)
    					for(int row = 0; row < m; row++)
        					sum += map[i + col][j + row];
    				max = Math.max(max, sum);
    			}
    		System.out.println("#" + tn + " " + max);
    	}
    }
    
}