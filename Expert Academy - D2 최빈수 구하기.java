import java.util.Scanner;

public class Solution {
	
	static Scanner sc = new Scanner(System.in);
	static int tc, tn, num[];
	
    public static void main(String[] args) {
    	tc = sc.nextInt();
    	while(tc-- > 0) {
    		tn = sc.nextInt();
    		num = new int[101];
    		for(int i = 0; i < 1000; i++)
    			num[sc.nextInt()]++;
    		int max = 0;
    		for(int i = 1; i <= 100; i++)
    			if(num[max] <= num[i])
    				max = i;
    		System.out.println("#" + tn + " " + max);
    	}
    }
    
}