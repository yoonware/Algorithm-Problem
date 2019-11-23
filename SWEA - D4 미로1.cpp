#include <iostream>
#include <string>
using namespace std;

int tc, sy, sx, isFind, board[16][16];
string line;

void find(int y, int x)
{
	int &value = board[y][x];
	if (value == 1) return;
	if (value == 4) return;
	if (value == 3) isFind = 1;
	if (isFind)     return;

	value = 4;
	find(y, x + 1); find(y, x - 1);
	find(y + 1, x); find(y - 1, x);
}

int main(void)
{
	while (tc != 10)
	{
		getline(cin, line);
		tc = atoi(line.c_str());
		for (int y = 0; y < 16; y++)
		{
			getline(cin, line);
			for (int x = 0; x < 16; x++)
			{
				board[y][x] = line[x] - '0';
				if (board[y][x] == 2)
				{
					sy = y; sx = x;
				}
			}
		}
		isFind = 0;
		find(sy, sx);
		cout << "#" << tc << " " << isFind << endl;
	}
	return 0;
}