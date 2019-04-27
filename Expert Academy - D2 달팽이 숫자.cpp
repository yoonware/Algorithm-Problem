#include <iostream>
#include <cstring>
using namespace std;

int t, n, num = 0;
int board[10][10];

int main(void)
{
	cin >> t;
	while (t-- > 0)
	{
		cin >> n;
		memset(board, 0, sizeof(board));
		int x = 0;
		int y = 0;
		int value = 1;
		int max = n * n;
		while (true) {
			for (int i = x; i < n; i++)
			{
				if (board[y][i] != 0) break;
				board[y][i] = value++;
				x = i;
			}
			y++;
			if (value > max) break;
			for (int i = y; i < n; i++)
			{
				if (board[i][x] != 0) break;
				board[i][x] = value++;
				y = i;
			}
			x--;
			if (value > max) break;
			for (int i = x; i >= 0; i--)
			{
				if (board[y][i] != 0) break;
				board[y][i] = value++;
				x = i;
			}
			y--;
			if (value > max) break;
			for (int i = y; i >= 0; i--)
			{
				if (board[i][x] != 0) break;
				board[i][x] = value++;
				y = i;
			}
			x++;
			if (value > max) break;
		}
		cout << "#" << ++num << endl;
		for (int i = 0; i < n; i++)
		{
			for (int j = 0; j < n; j++)
				cout << board[i][j] << " ";
			cout << endl;
		}
	}
}