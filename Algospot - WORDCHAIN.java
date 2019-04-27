import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	
	static FastScanner   fs = new FastScanner();
	static StringBuilder sb = new StringBuilder();
	
	static int N;
	static int out[], in[], edge[][];
	static Word word[][];
	static ArrayList<Integer> circuit;
	
	public static void main(String[] args) {
		
		int C = fs.nextInt();
		
		while(C-- > 0) {
			
			initialize();
			
			if(isPossible()) {
				getEulerTrailOrCircuit();
				for(int i=N; i>0; i--) {
					sb.append(word[circuit.get(i)][circuit.get(i-1)].list.remove(0));
					if(i != 1)
						sb.append(" ");
					else
						sb.append("\n");
				}
			}
			else {
				sb.append("IMPOSSIBLE\n");
			}
		}
		
		System.out.print(sb.toString());
	}
	
	static void initialize() {
		
		N    = fs.nextInt();
		out  = new int [26];
		in   = new int [26];
		edge = new int [26][26];
		word = new Word[26][26];
		for(int i=0; i<26; i++) {
			for(int j=0; j<26; j++) {
				word[i][j] = new Word();
			}
		}
		for(int i=0; i<N; i++) {
			String w = fs.next();
			int a = w.charAt(0) - 97;
			int b = w.charAt(w.length() - 1) - 97;
			word[a][b].list.add(w);
			edge[a][b]++;
			out [a]   ++;
			in  [b]   ++;
		}
	}
	
	static void getEulerCircuit(int start) {
		
		for(int end = 0; end < 26; end++) {
			while(edge[start][end] > 0) {
				edge[start][end]--;
				getEulerCircuit(end);
			}
		}
		circuit.add(start);
	}
	
	static void getEulerTrailOrCircuit() {
		
		circuit = new ArrayList<>();
		for(int i=0; i<26; i++) {
			if(out[i] - in[i] == 1) {
				getEulerCircuit(i);
				return;
			}
		}
		for(int i=0; i<26; i++) {
			if(out[i] != 0) {
				getEulerCircuit(i);
				return;
			}
		}
	}
	
	static boolean isPossible() {
		
		int start = 0, end = 0;
		for(int i=0; i<26; i++) {
			int outEdge = out[i] - in[i];
			if(outEdge > 1 || outEdge < -1) {
				return false;
			}
			else if(outEdge == 1) {
				start++;
			}
			else if(outEdge == -1) {
				end++;
			}
		}
		if((start == 1 && end == 1) || (start == 0 && end == 0)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	static class Word {
		
		ArrayList<String> list;
		
		Word() {
			list = new ArrayList<>();
		}
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
