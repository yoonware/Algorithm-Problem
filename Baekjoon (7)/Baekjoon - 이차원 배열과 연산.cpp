#include <iostream>
#include <cstring>
#include <queue>
#include <utility>
using namespace std;

int r, c, k, a[101][101], cnt[101];
int row = 3, col = 3;

void R()
{
	int big = 0;
	for (int y = 1; y <= row; y++)
	{
		priority_queue<pair<int, int>> pq;
		memset(cnt, 0, sizeof(cnt));
		for (int x = 1; x <= col; x++)
		{
			cnt[a[y][x]]++;
			a[y][x] = 0;
		}
		for (int value = 1; value <= 100; value++)
			if (cnt[value])
				pq.push(make_pair(-cnt[value], -value));
		int len = min(100, (int)pq.size() * 2);
		for (int i = 1; i <= len; i += 2)
		{
			a[y][i] = -pq.top().second;
			a[y][i + 1] = -pq.top().first;
			pq.pop();
		}
		big = max(big, len);
	}
	col = big;
}

void C()
{
	int big = 0;
	for (int x = 1; x <= col; x++)
	{
		priority_queue<pair<int, int>> pq;
		memset(cnt, 0, sizeof(cnt));
		for (int y = 1; y <= row; y++)
		{
			cnt[a[y][x]]++;
			a[y][x] = 0;
		}
		for (int value = 1; value <= 100; value++)
			if (cnt[value])
				pq.push(make_pair(-cnt[value], -value));
		int len = min(100, (int)pq.size() * 2);
		for (int i = 1; i <= len; i += 2)
		{
			a[i][x] = -pq.top().second;
			a[i + 1][x] = -pq.top().first;
			pq.pop();
		}
		big = max(big, len);
	}
	row = big;
}

int main(void)
{
	cin >> r >> c >> k;
	for (int y = 1; y <= 3; y++)
		for (int x = 1; x <= 3; x++)
			cin >> a[y][x];
	for (int t = 0; t < 101; t++)
	{
		if (a[r][c] == k)
		{
			cout << t << endl;
			return 0 ;
		}
		if (row >= col)
			R();
		else
			C();
	}
	cout << -1 << endl;
	return 0;
}