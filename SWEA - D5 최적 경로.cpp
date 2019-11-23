#include <iostream>
using namespace std;

int tc, n, dx, dy, answer;
int start[2], goal[2];
int node[10][2];
bool visit[10];

int getDist(int x1, int y1, int x2, int y2) {
	dx = x1 - x2;
	dy = y1 - y2;
	if (dx < 0) dx *= -1;
	if (dy < 0) dy *= -1;
	return (dx + dy);
}

void dfs(int y, int x, int dist, int cnt) {
	if (dist >= answer)
		return;
	if (cnt == n) {
		dist += getDist(y, x, goal[0], goal[1]);
		if (dist < answer)
			answer = dist;
		return;
	}
	for (int i = 0; i < n; i++) {
		if (!visit[i]) {
			visit[i] = true;
			dfs(node[i][0], node[i][1], dist + getDist(y, x, node[i][0], node[i][1]), cnt + 1);
			visit[i] = false;
		}
	}
}

int main() {
	cin >> tc;
	for (int i = 1; i <= tc; i++) {
		answer = 1000000;
		cin >> n >> start[0] >> start[1] >> goal[0] >> goal[1];
		for (int j = 0; j < n; j++) {
			cin >> node[j][0] >> node[j][1];
			visit[j] = false;
		}
		dfs(start[0], start[1], 0, 0);
		cout << "#" << i << " " << answer << endl;
	}
	return 0;
}