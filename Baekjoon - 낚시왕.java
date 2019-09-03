import java.util.Scanner;

public class Solution {
	
	static Scanner sc = new Scanner(System.in);
	static int R, C, M, MAP[][], answer;
	static shark SHARK[];
	
	public static void main(String[] args) {
		R = sc.nextInt();
		C = sc.nextInt();
		M = sc.nextInt();
		MAP = new int[R][C];
		SHARK = new shark[M + 1];
		for(int i = 0; i < M; i++) {
			int r = sc.nextInt() - 1;
			int c = sc.nextInt() - 1;
			int s = sc.nextInt();
			int d = sc.nextInt();
			int z = sc.nextInt();
			MAP[r][c] = i + 1;
			SHARK[i + 1] = new shark(r, c, s, d, z);
		}
		for(int man = 0; man < C; man++) {
			for(int j = 0; j < R; j++) {
				if(MAP[j][man] != 0) {
					answer += SHARK[MAP[j][man]].size;
					SHARK[MAP[j][man]].isAlive = false;
					MAP[j][man] = 0;
					break;
				}
			}
			for(int k = 1; k < M + 1; k++) {
				if(SHARK[k].isAlive == false)
					continue;
				int move = SHARK[k].speed;
				while(move > 0) {
					switch(SHARK[k].dir) {
					case 1:
						if(SHARK[k].row - move >= 0) {
							SHARK[k].row -= move;
							move = -1;
						}
						else {
							move -= SHARK[k].row;
							SHARK[k].row = 1;
							SHARK[k].dir = 2;
						}
						break;
					case 2:
						if(SHARK[k].row + move < R) {
							SHARK[k].row += move;
							move = -1;
						}
						else {
							move -= (R - SHARK[k].row - 1);
							SHARK[k].row = R - 2;
							SHARK[k].dir = 1;
						}
						break;
					case 3:
						if(SHARK[k].col + move < C) {
							SHARK[k].col += move;
							move = -1;
						}
						else {
							move -= (C - SHARK[k].col - 1);
							SHARK[k].col = C - 2;
							SHARK[k].dir = 4;
						}
						break;
					case 4:
						if(SHARK[k].col - move >= 0) {
							SHARK[k].col -= move;
							move = -1;
						}
						else {
							move -= SHARK[k].col;
							SHARK[k].col = 1;
							SHARK[k].dir = 3;
						}
						break;
					}
					move -= 1;
				}
			}
			MAP = new int[R][C];
			for(int k = 1; k < M + 1; k++) {
				if(SHARK[k].isAlive == false) {
					continue;
				}
				int r = SHARK[k].row;
				int c = SHARK[k].col;
				if(MAP[r][c] == 0)
					MAP[r][c] = k;
				else {
					int before = SHARK[MAP[r][c]].size;
					int after = SHARK[k].size;
					if(after > before) {
						SHARK[MAP[r][c]].isAlive = false;
						MAP[r][c] = k;
					}
					else
						SHARK[k].isAlive = false;
				}
			}
		}
		System.out.println(answer);
	}
	
	static class shark {
		boolean isAlive;
		int row;
		int col;
		int speed;
		int dir;
		int size;
		shark(int r, int c, int s, int d, int z) {
			isAlive = true;
			row = r;
			col = c;
			speed = s;
			dir = d;
			size = z;
		}
	}
	
}