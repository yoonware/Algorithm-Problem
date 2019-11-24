#include <iostream>
using namespace std;

int n, limit, temp, answer, num[11];
bool map[11][11], choice[11], visit[11];

// �Է�
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

// ���� ������ ��� ��忡 �湮
void dfs(int team, int now) {
	visit[now] = true;
	for (int i = 1; i <= n; i++)
		if (choice[i] == team)         // ���� �׷��̰�
			if (map[now][i] == true)   // ����Ǿ� ������
				if (visit[i] == false) // ���� �湮���� �ʾҴٸ�
					dfs(team, i);      // �湮
}

// �� �׷��� ���Ἲ üũ
bool isConnected() {
	for (int i = 1; i <= n; i++) // �湮���� �ʱ�ȭ
		visit[i] = false;
	for (int i = 1; i <= n; i++) // ���� �׷�
		if (choice[i]) {
			dfs(true, i);
			break;
		}
	for (int i = 1; i <= n; i++) // �̼��� �׷�
		if (!choice[i]) {
			dfs(false, i);
			break;
		}
	for (int i = 1; i <= n; i++) // ��� ��忡 �湮 �ߴ��� �˻�
		if (visit[i] == false)
			return false;
	return true;
}

// �� ���ű��� �α� ���� ���
int calculate() {
	int ret = 0;
	for (int i = 1; i <= n; i++)
		if (choice[i]) ret += num[i]; // ���� �׷� (+)
		else           ret -= num[i]; // �̼��� �׷� (-)
	return ret >= 0 ? ret : -ret;     // ���� ��ȯ
}

// ���ű� ������
void divide(int now, int cnt) {
	choice[now] = true;
	if (isConnected())                     // �� �׷��� ���� ����Ǿ� �ִٸ�
		if (answer > (temp = calculate())) // �� �׷��� �α����� ���
			answer = temp;
	if (cnt < limit)                       // ��ü�� ���ݸ� �����ϸ� ��
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