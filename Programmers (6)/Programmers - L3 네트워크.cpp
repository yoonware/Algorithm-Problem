#include <string>
#include <vector>

using namespace std;

int limit, answer;
vector<bool> visit;
vector<vector<int>> matrix;

void dfs(int node) {
	if (visit[node]) {
		return;
	}
	visit[node] = true;
	for (int i = 0; i < limit; i++) {
		if (matrix[node][i] == 1) {
			dfs(i);
		}
	}
}

int solution(int n, vector<vector<int>> computers) {
	for (int i = 0; i < n; i++) computers[i][i] = 0;
	matrix.assign(computers.begin(), computers.end());
	visit.assign(n, false);
	limit = n;
	for (int i = 0; i < n; i++) {
		if (!visit[i]) {
			answer++;
			dfs(i);
		}
	}
	return answer;
}