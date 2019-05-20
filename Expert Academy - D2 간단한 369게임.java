import java.util.Scanner;

public class Solution {
	
	static Scanner sc = new Scanner(System.in);
	static StringBuilder sb = new StringBuilder();
	static int n, clap, num;
	static String word, temp;
	
    public static void main(String[] args) {
    	
    	// 초기 입력
    	n = sc.nextInt();
    	// 입려된 숫자까지 검사
    	for(int i = 1; i <= n; i++) {
    		// 숫자를 문자열로 바꿈
    		word = i + "";
    		// 초기화
    		temp = "";
    		clap = 0;
    		// 문자열 길이만큼 검사
    		for(int j = 0; j < word.length(); j++) {
    			num = word.charAt(j) - '0';
    			if(num != 0 && num % 3 == 0)
    				clap++;
    			else
    				temp += num;
    		}
    		// 박수 칠 필요가 없다면 숫자 출력
    		if(clap == 0)
    			sb.append(temp);
    		// 박수 칠 필요가 있다면 박수 개수만큼 출력
    		else {
    			for(int j = 0; j < clap; j++)
    				sb.append("-");
    		}
    		// 띄어쓰기
    		sb.append(" ");
    	}
    	System.out.println(sb.toString());
    }
    
}