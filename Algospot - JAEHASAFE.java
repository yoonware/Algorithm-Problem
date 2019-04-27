import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	
	static int count, C;

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder  sb = new StringBuilder();
		C = Integer.parseInt(br.readLine());
		
		while(C-- > 0) {
			int N   = Integer.parseInt(br.readLine());
			String original = br.readLine();;
			for(int i=1; i<N+1; i++) {
				String target = br.readLine();
				if(i%2 == 0)
					shifts(original, target);
				else
					shifts(target, original);
				original = target;
			}
			sb.append(count); sb.append("\n"); count = 0;
		}
		
		System.out.print(sb.toString());
	}
	
	static void shifts(String original, String target) {
		
		count += kmpSearch(original + original, target).get(0);
	}
	
	static ArrayList<Integer> kmpSearch(String H, String N) {
		
		int n = H.length();
		int m = N.length();
		ArrayList<Integer> ret = new ArrayList<>();
		int pi[] = getPartialMatch(N);
		int matched = 0;
		for(int i=0; i<n; i++) {
			while(matched>0 && H.charAt(i) != N.charAt(matched))
				matched = pi[matched-1];
			if(H.charAt(i) == N.charAt(matched)) {
				++matched;
				if(matched == m) {
					ret.add(i-m+1);
					matched = pi[matched-1];
				}
			}
		}
		return ret;
	}
	
	static int[] getPartialMatch(String N) {
		
		int m = N.length();
		int pi[] = new int[m];
		int begin = 1, matched = 0;
		while(begin + matched < m) {
			if(N.charAt(begin + matched) == N.charAt(matched)) {
				++matched;
				pi[begin+matched-1] = matched;
			}
			else {
				if(matched == 0)
					++begin;
				else {
					begin += matched - pi[matched-1];
					matched = pi[matched-1];
				}
			}
		}
		return pi;
	}
	
}
