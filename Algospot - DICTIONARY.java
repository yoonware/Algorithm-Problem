import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	
	static FastScanner   fs = new FastScanner();
	static StringBuilder sb = new StringBuilder();
	
	static int N;
	static String S[];
	static int VISIT[], EDGE[][];
	static ArrayList<Integer> LIST;

	public static void main(String[] args) {
		
		int C = fs.nextInt();
		
		while(C-- > 0) {
			
			// 전역변수 초기화, 케이스 입력
			initialize();
			
			// 인접행렬 생성 (재귀)
			for(int i=0; i<N-1; i++)
				compare(S[i], S[i+1], Math.min(S[i].length(), S[i+1].length()), 0);
			
			// 알파벳 순서 결정 (깊이 우선 탐색)
			for(int i=0; i<26; i++)
				for(int j=0; j<26; j++)
					if(EDGE[i][j] != 0 && VISIT[i] == 0)
						dfs(i);
			
			// 알파벳 순서에 모순이 없을 경우
			if(isLogical()) {
				for(int i=0; i<LIST.size(); i++)
					sb.append((char)(LIST.get(i)+'a'));
				for(int i=0; i<26; i++)
					if(!LIST.contains(i))
						sb.append((char)(i+'a'));
				sb.append("\n");
			}
			// 알파벳 순서에 모순이 있을 경우
			else
				sb.append("INVALID HYPOTHESIS\n");
		}
		System.out.print(sb.toString());
	}
	
	// 전역변수 초기화, 케이스 입력
	static void initialize() {
		
		EDGE  = new int[26][26];
		VISIT = new int[26];
		LIST  = new ArrayList<>();
		N     = fs.nextInt();
		S     = new String[N];
		for(int i=0; i<N; i++)
			S[i] = fs.next();
	}
	
	// 인접행렬 생성 (재귀)
	static void compare(String s1, String s2, int len, int level) {
		
		int a = s1.charAt(level) - 'a';
		int b = s2.charAt(level) - 'a';
		if(a != b)
			EDGE[a][b] = 1;
		else if(len > level+1)
			compare(s1, s2, len, level+1);
	}
	
	// 알파벳 순서 결정 (깊이 우선 탐색)
	static void dfs(int start) {
		
		VISIT[start] = 1;
		for(int end=0; end<26; end++)
			if(EDGE[start][end] != 0 && VISIT[end] == 0)
				dfs(end);
		LIST.add(start);
	}
	
	// 알파벳 순서의 모순 체크
	static boolean isLogical() {
		
		Collections.reverse(LIST);
		for(int i=0; i<LIST.size()-1; i++)
			for(int j=i+1; j<LIST.size(); j++)
				if(EDGE[LIST.get(j)][LIST.get(i)] == 1)
					return false;
		return true;
	}
	
	static class FastScanner {
		
		BufferedReader in;
		StringTokenizer st;
		
		FastScanner() {
			in = new BufferedReader(new InputStreamReader(System.in));
		}
		
		String next() {
			while(st == null || !st.hasMoreTokens()) {
				try {
					String str = in.readLine();
					if(str == null) {
						return null;
					}
					st = new StringTokenizer(str);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}
		
		int nextInt() {
			return Integer.parseInt(next());
		}
	}

}
