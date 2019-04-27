#include <iostream>
#include <vector>
#include <string>
using namespace std;

int n, a, i;
string str;
vector<pair<int, char>> fm;

int main()
{
	cin >> n >> a >> str;
	int now = 0;
	int change = -1;

	for (i = 0; i < n; i++)
	{
		if (i != a)
			fm.push_back(make_pair(i, str[now++]));
		else
			fm.push_back(make_pair(i, 'a'));
	}

	while (true)
	{
		for (i = 0; i < fm.size() - 1; i += 2)
		{
			char front = fm[i].second;
			char back = fm[i + 1].second;
			if (fm[i].first == a)
			{
				switch (back)
				{
				case 'R':
					if (front != 'P')
					{
						fm[i].second = 'P';
						change++;
					}
					break;
				case 'S':
					if (front != 'R')
					{
						fm[i].second = 'R';
						change++;
					}
					break;
				case 'P':
					if (front != 'S')
					{
						fm[i].second = 'S';
						change++;
					}
					break;
				}
				fm[i + 1].second = 'x';
				continue;
			}
			if (fm[i + 1].first == a)
			{
				switch (front)
				{
				case 'R':
					if (back != 'P')
					{
						fm[i + 1].second = 'P';
						change++;
					}
					break;
				case 'S':
					if (back != 'R')
					{
						fm[i + 1].second = 'R';
						change++;
					}
					break;
				case 'P':
					if (back != 'S')
					{
						fm[i + 1].second = 'S';
						change++;
					}
					break;
				}
				fm[i].second = 'x';
				continue;
			}
			if (front == back)
			{
				fm[i].second = 'x';
				fm[i + 1].second = 'x';
				continue;
			}
			if (front == 'R')
			{
				if (back == 'P')
					fm[i].second = 'x';
				if (back == 'S')
					fm[i + 1].second = 'x';
				continue;
			}
			if (front == 'S')
			{
				if (back == 'R')
					fm[i].second = 'x';
				if (back == 'P')
					fm[i + 1].second = 'x';
				continue;
			}
			if (front == 'P')
			{
				if (back == 'S')
					fm[i].second = 'x';
				if (back == 'R')
					fm[i + 1].second = 'x';
				continue;
			}
		}
		for ( i = fm.size() - 1; i >= 0; i--)
			if (fm[i].second == 'x')
				fm.erase(fm.begin() + i);
		if (fm.size() == 1)
			break;
	}
	cout << change << endl;
	return 0;
}