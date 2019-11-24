#include <iostream>
using namespace std;

int n, limit, temp, answer, num[11];
bool map[11][11], choice[11], visit[11];

// 입력
void init() {
	cin >> n;
	limit = n / 2;
	answer = 1000000;
	for (int i = 1; i <= n; i++)
		cin >> num[i];
	for (int i = 1; i <= n; i++) {
		int c, k;
		cin >> c;
		for (int j = 0; j < c; j++) {
			cin >> k;
			map[i][k] = true;
		}
	}
}

// 접근 가능한 모든 노드에 방문
void dfs(int team, int now) {
	visit[now] = true;
	for (int i = 1; i <= n; i++)
		if (choice[i] == team)         // 같은 그룹이고
			if (map[now][i] == true)   // 연결되어 있으며
				if (visit[i] == false) // 아직 방문하지 않았다면
					dfs(team, i);      // 방문
}

// 두 그룹의 연결성 체크
bool isConnected() {
	for (int i = 1; i <= n; i++) // 방문여부 초기화
		visit[i] = false;
	for (int i = 1; i <= n; i++) // 선택 그룹
		if (choice[i]) {
			dfs(true, i);
			break;
		}
	for (int i = 1; i <= n; i++) // 미선택 그룹
		if (!choice[i]) {
			dfs(false, i);
			break;
		}
	for (int i = 1; i <= n; i++) // 모든 노드에 방문 했는지 검사
		if (visit[i] == false)
			return false;
	return true;
}

// 두 선거구의 인구 차이 계산
int calculate() {
	int ret = 0;
	for (int i = 1; i <= n; i++)
		if (choice[i]) ret += num[i]; // 선택 그룹 (+)
		else           ret -= num[i]; // 미선택 그룹 (-)
	return ret >= 0 ? ret : -ret;     // 절댓값 반환
}

// 선거구 나누기
void divide(int now, int cnt) {
	choice[now] = true;
	if (isConnected())                     // 두 그룹이 각각 연결되어 있다면
		if (answer > (temp = calculate())) // 두 그룹의 인구차이 계산
			answer = temp;
	if (cnt < limit)                       // 전체의 절반만 선택하면 됨
		for (int i = now + 1; i <= n; i++)
			divide(i, cnt + 1);
	choice[now] = false;
}

int main() {
	init();
	for (int i = 1; i <= n; i++)
		divide(i, 1);
	if (answer == 1000000)
		answer = -1;
	cout << answer;
	return 0;
}