#include <iostream>
using namespace std;

#define N 4

typedef struct {
	int strike;
	int ball;
} Result;

// API
extern Result query(int guess[]);

Result check;
bool never[10];
int score, cand[4];

bool dfs(int num, int index) {
	if (never[num])
		return false;
	cand[index] = num;

	if (index == 3) {
		check = query(cand);
		score = check.strike + check.ball;
		// 4���� ���ڸ� ã���� ��
		if (score == N)
			return true;
		// �� ���ڵ��� ���信 �ϳ��� ���Ե��� ���� ��
		if (score == 0)
			for (int i = 0; i < N; i++)
				never[cand[i]] = true;
		return false;
	}

	for (int i = num + 1; i < 10; i++) {
		if (never[num])
			return false;
		if (dfs(i, index + 1))
			return true;
	}
	return false;
}

void doUserImplementation(int guess[]) {
	
	// ���� (4�� ã��)
	for (int i = 0; i < 10; i++) never[i] = false;
	for (int i = 0; i < 10; i++) if (dfs(i, 0)) break;

	// ���� (�ڸ� ���߱�)
	int a, b, c, d;
	for (a = 0; a < N; a++) {
		guess[0] = cand[a];
		for (b = 0; b < N; b++) {
			if (a == b) continue;
			guess[1] = cand[b];
			for (c = 0; c < N; c++) {
				if (a == c || b == c) continue;
				guess[2] = cand[c];
				for (d = 0; d < N; d++) {
					if (a == d || b == d || c == d) continue;
					guess[3] = cand[d];
					check = query(guess);
					if (check.strike == N) return;
				}
			}
		}
	}
}