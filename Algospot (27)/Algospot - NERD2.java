import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;
import java.util.Map.Entry;

public class Main {
	
	static int C, N, SUM;
	static TreeMap<Integer, Integer> BT;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		C = Integer.parseInt(br.readLine());
		
		while(C-- > 0) {
			N = Integer.parseInt(br.readLine());
			BT = new TreeMap<>();
			SUM = 0;
			for(int i=0; i<N; i++) {
				String str[] = br.readLine().split(" ");
				SUM += nerd(Integer.parseInt(str[0]), Integer.parseInt(str[1]));
			}
			System.out.println(SUM);
		}
		
	}
	
	static int nerd(int x, int y) {
		
		Entry<Integer, Integer> entry = BT.higherEntry(x);
		if(entry == null || entry.getValue() < y) {
			BT.put(x, y);
			while(true) {
				entry = BT.lowerEntry(x);
				if(entry == null) {
					break;
				}
				else if(entry.getValue() < y) {
					BT.remove(entry.getKey());
				}
				else {
					break;
				}
			}
		}
		return BT.size();
	}

}
