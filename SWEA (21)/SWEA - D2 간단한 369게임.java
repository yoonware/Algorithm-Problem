import java.util.Scanner;

public class Solution {
	
	static Scanner sc = new Scanner(System.in);
	static StringBuilder sb = new StringBuilder();
	static int n, clap, num;
	static String word, temp;
	
    public static void main(String[] args) {
    	
    	// �ʱ� �Է�
    	n = sc.nextInt();
    	// �Է��� ���ڱ��� �˻�
    	for(int i = 1; i <= n; i++) {
    		// ���ڸ� ���ڿ��� �ٲ�
    		word = i + "";
    		// �ʱ�ȭ
    		temp = "";
    		clap = 0;
    		// ���ڿ� ���̸�ŭ �˻�
    		for(int j = 0; j < word.length(); j++) {
    			num = word.charAt(j) - '0';
    			if(num != 0 && num % 3 == 0)
    				clap++;
    			else
    				temp += num;
    		}
    		// �ڼ� ĥ �ʿ䰡 ���ٸ� ���� ���
    		if(clap == 0)
    			sb.append(temp);
    		// �ڼ� ĥ �ʿ䰡 �ִٸ� �ڼ� ������ŭ ���
    		else {
    			for(int j = 0; j < clap; j++)
    				sb.append("-");
    		}
    		// ����
    		sb.append(" ");
    	}
    	System.out.println(sb.toString());
    }
    
}