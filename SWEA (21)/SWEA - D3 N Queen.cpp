#include<iostream>
using namespace std;

int tc, tn, n, map[10][10], answer;

void setMap(int col, int row, int value)
{
	for (int i = 1; col + i < n; i++)
		map[col + i][row] += value;
	for (int i = 1; col + i < n && row + i < n; i++)
		map[col + i][row + i] += value;
	for (int i = 1; col + i < n && row - i >= 0; i++)
		map[col + i][row - i] += value;
}

void dfs(int col, int count)
{
	if (count == n)
	{
		answer++;
		return;
	}

	for (int x = 0; x < n; x++)
	{
		if (map[col][x] == 0)
		{
			setMap(col, x, 1);
			dfs(col + 1, count + 1);
			setMap(col, x, -1);
		}
	}
}

int main(void)
{
	cin >> tc;
	while (tn++ != tc)
	{
		cin >> n;
		answer = 0;
		for (int y = 0; y < n; y++)
			for (int x = 0; x < n; x++)
				map[y][x] = 0;
		dfs(0, 0);
		cout << "#" << tn << " " << answer << endl;
	}	
	cin >> tc;
	return 0;
}