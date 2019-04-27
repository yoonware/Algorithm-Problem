import java.util.Scanner;

public class Main {
	
	static Scanner sc = new Scanner(System.in);
	static StringBuilder sb = new StringBuilder();
	static int c, h, w, count, empty;
	static int board[][];

	public static void main(String[] args) {
		
		c = sc.nextInt();
		while(c-- > 00 ) {
			
			// 보드의 세로-가로 길이 입력
			h = sc.nextInt();
			w = sc.nextInt();
			
			// 전역변수 초기화
			count = 0;
			empty = 0;
			
			// 보드의 상태 입력
			board = new int[h][w];
			for(int i=0; i<h; i++) {
				String line = sc.next();
				for(int k=0; k<w; k++) {
					if(line.charAt(k) == '#')
						board[i][k] = 1;
					else
						empty++;
				}
			}
			
			// 보드의 빈칸 수가 3의 배수인지 확인 -> 탐색
			if(empty % 3 == 0) {
				dfs();
			}
			sb.append(count+"\n");
		}
		System.out.print(sb.toString());
	}
	
	static void dfs() {
		
		int col = -1;
		int row = -1;
		
		// 첫 빈칸 검색
		for(int i=0; i<h; i++) {
			for(int k=0; k<w; k++) {
				if(board[i][k] == 0) {
					col = i;
					row = k;
					break;
				}
			}
			
			// 반복문 종료 (빈칸 있음)
			if(col != -1) {
				break;
			}
		}
		
		// 탐색 종료 (빈칸 없음)
		if(col == -1) {
			count++;
			return;
		}
		
		// 탐색 시작
		if(col < h-1 && row < w-1) {
			if( board[col+1][row] ==   0 && board[col][row+1] == 0) {
				board[col+1][row] =    1;   board[col][row+1] =  1; board[col][row] = 1; dfs();
				board[col+1][row] =    0;   board[col][row+1] =  0; board[col][row] = 0;
			}
			if( board[col+1][row+1] == 0 && board[col][row+1] == 0) {
				board[col+1][row+1] =  1;   board[col][row+1] =  1; board[col][row] = 1; dfs();
				board[col+1][row+1] =  0;   board[col][row+1] =  0; board[col][row] = 0;
			}
			if( board[col+1][row+1] == 0 && board[col+1][row] == 0) {
				board[col+1][row+1] =  1;   board[col+1][row] =  1; board[col][row] = 1; dfs();
				board[col+1][row+1] =  0;   board[col+1][row] =  0; board[col][row] = 0;
			}
		}
		if(col < h-1 && row > 0) {
			if( board[col+1][row-1] == 0 && board[col+1][row] == 0) {
				board[col+1][row-1] =  1;   board[col+1][row] =  1; board[col][row] = 1; dfs();
				board[col+1][row-1] =  0;   board[col+1][row] =  0; board[col][row] = 0;
			}
		}
	}

}
