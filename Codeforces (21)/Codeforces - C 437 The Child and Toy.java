import java.util.Scanner;

public class Solution {
	
	static Scanner sc = new Scanner(System.in);
	static int n, m, a, b, v[], edge[][], answer;
	
    public static void main(String[] args) {
    	n = sc.nextInt();
    	m = sc.nextInt();
    	v = new int[n + 1];
    	edge = new int[n + 1][n + 1];
    	for(int i = 1; i <= n; i++)
    		v[i] = sc.nextInt();
    	for(int i = 1; i <= m; i++)
    		answer += Math.min(v[sc.nextInt()], v[sc.nextInt()]);
    	System.out.println(answer);
    }
    
}