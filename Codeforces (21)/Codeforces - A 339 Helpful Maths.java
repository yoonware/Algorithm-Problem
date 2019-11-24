import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder  sb = new StringBuilder();
		
		String string[] = br.readLine().split("\\+");
		int    count[]  = new int[3]; 
		
		for(int i=0; i<string.length; i++) {
			count[Integer.parseInt(string[i])-1]++;
		}
		
		for(int i=0; i<count[0]; i++) {
			sb.append("1+");
		}
		
		for(int i=0; i<count[1]; i++) {
			sb.append("2+");
		}
		
		for(int i=0; i<count[2]; i++) {
			sb.append("3+");
		}
		
		String answer = sb.toString();
		System.out.print(answer.substring(0, answer.length()-1));
	
	}

}
