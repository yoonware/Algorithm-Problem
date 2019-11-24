import java.util.Scanner;

public class Main {
	
	static Scanner sc = new Scanner(System.in);
	static StringBuilder sb = new StringBuilder();
	static int c, n, l;
	static double min, cost[];

	public static void main(String[] args) {
		
		// 테스트 케이스 수 입력
		c = sc.nextInt();
		
		while(c-- > 0) {
			
			// 입력 및 전역변수 초기화
			n    = sc.nextInt();
			l    = sc.nextInt();
			min  = 100;
			cost = new double[n];
			for(int i=0; i<n; i++) {
				cost[i] = sc.nextInt();
			}
			
			// 최소 평균 대여 비용 구하기 (날짜별로 수행)
			for(int day=l; day<n+1; day++) {
				getMin(day);
			}
			sb.append(min+"\n");
		}
		
		System.out.print(sb.toString());
	}
	
	static void getMin(int day) {
		
		for(int i=0; i<n-day+1; i++) {
			double sum = 0;
			for(int k=i; k<i+day; k++) {
				sum += cost[k];
			}
			min = Math.min(min, sum/day);
		}
	}
	
}
