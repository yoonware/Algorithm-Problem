import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	
	static ArrayList<Integer> node;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {	
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int C = Integer.parseInt(br.readLine());
		
		while(C-- > 0) {
			// 읽기
			String NQ[]     = br.readLine().split(" ");
			String parent[] = br.readLine().split(" ");
			
			// 입력
			int N = Integer.parseInt(NQ[0]);
			int Q = Integer.parseInt(NQ[1]);
			node = new ArrayList<>();
			node.add(-1);
			for(int i=0; i<N-1; i++)
				node.add(Integer.parseInt(parent[i]));
			
			// 각 쌍마다 계산
			for(int i=0; i<Q; i++) {
				// 각 쌍 입력
				String point[] = br.readLine().split(" ");
				int p1 = Integer.parseInt(point[0]);
				int p2 = Integer.parseInt(point[1]);
				// 촌수 구하기
				getDegree(p1, p2);
			}
		}
		
		// 출력
		System.out.print(sb.toString());
	}
	
	static void getDegree(int point1, int point2) {
		
		boolean flag = true;
		int height1 = 0;
		int height2 = 0;
		
		if(point1 == point2) {
			sb.append("0\n");
			flag = false;
		}
		 
		if(flag && point1 != 0) {
			int now1 = point1;
			while(true) {
				height1++;
				now1 = node.get(now1);
				if(now1 == 0) {
					break;
				}
				else if(now1 == point2) {
					sb.append(height1); sb.append("\n");
					flag = false;
					break;
				}
			}
			if(flag && point2 == 0) {
				sb.append(height1); sb.append("\n");
				flag = false;
			}
		}
		
		if(flag && point2 != 0) {
			int now2 = point2;
			while(true) {
				height2++;
				now2 = node.get(now2);
				if(now2 == 0) {
					break;
				}
				else if(now2 == point1) {
					sb.append(height2); sb.append("\n");
					flag = false;
					break;
				}
			}
			if(flag && point1 == 0) {
				sb.append(height2); sb.append("\n");
				flag = false;
			}
		}
		
		if(flag) {
			int now1 = point1;
			int now2 = point2;
			int answer = 0;
			if(height1 == height2) {
				answer = getCommonAncestor(now1, now2);
				sb.append(answer * 2); sb.append("\n");
			}
			else if(height1 > height2) {
				int gap = height1 - height2;
				for(int k=0; k<gap; k++) {
					now1 = node.get(now1);
				}
				answer = getCommonAncestor(now1, now2);
				sb.append(answer * 2 + gap); sb.append("\n");
			}
			else if(height1 < height2) {
				int gap = height2 - height1;
				for(int k=0; k<height2-height1; k++) {
					now2 = node.get(now2);
				}
				answer = getCommonAncestor(now1, now2);
				sb.append(answer * 2 + gap); sb.append("\n");
			}
		}
	}
	
	static int getCommonAncestor(int n1, int n2) {
		int now1 = n1;
		int now2 = n2;
		int answer = 0;
		while(true) {
			answer++;
			now1 = node.get(now1);
			now2 = node.get(now2);
			if(now1 == now2)
				break;
		}
		return answer;
	}
	
}
