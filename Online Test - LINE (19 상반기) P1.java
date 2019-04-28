import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        long num = sc.nextLong();
        int sqrt = (int) Math.sqrt(num);
        for(int i = sqrt; i <= num; i++) {
        	if(num % i == 0) {
        		System.out.print(Math.abs(i - (num / i)));
        		return;
        	}
        }
	}

}