#include <iostream>
using namespace std;

int n, m, answer = -1;

void dfs(int num, int count)
{
	if (answer != -1)
		return;
	if (num == m)
		answer = count;
	if (num >= m)
		return;
	dfs(num * 2, count + 1);
	dfs(num * 3, count + 1);
}

int main(void)
{
	cin >> n >> m;
	dfs(n, 0);
	cout << answer;
}