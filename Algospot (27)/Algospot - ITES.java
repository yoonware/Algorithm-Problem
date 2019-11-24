import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		int C, K, N;
		
		ArrayList<Long> sList;
		long A;
		long sum;
		int  count;
		
		Scanner scan = new Scanner(System.in);
		C = scan.nextInt();
		
		while(C-- > 0) {
			K = scan.nextInt();
			N = scan.nextInt();
			
			sList = new ArrayList<>();
			A = 1983;
			sum = 0;
			count = 0;
			
			for(int i=0; i<N; i++) {
				sList.add(A % 10000 + 1);
				A = (A * 214013L + 2531011L) % 4294967296L;
				
				sum += sList.get(i);
				while(sum > K) {
					sum -= sList.remove(0);
					i--; N--;
				}
				
				if(sum == K) {
					count++;
				}
			}
			
			System.out.println(count);
		}
		
		scan.close();
	}
	
}
