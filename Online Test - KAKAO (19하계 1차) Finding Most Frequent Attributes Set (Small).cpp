#include <iostream>
#include <string>
#include <sstream>
#include <set>
using namespace std;

bool isSame;
double th, num, row;
int now, ch[6];
string input, sub, info[3000][6];
set<string> result;

void calculate()
{
	for (int start = 0; start < row; start++)
	{
		int sum = 0;
		for (int next = 0; next < row; next++)
		{
			isSame = true;
			for (int index = 0; index < num; index++)
			{
				if (info[start][ch[index]] != info[next][ch[index]])
				{
					isSame = false;
					break;
				}
			}
			if (isSame)
				sum++;
		}
		if ((sum / row) >= th)
		{
			string output;
			for (int index = 0; index < num; index++)
			{
				output.append(info[start][ch[index]]);
				if (index == num - 1)
					break;
				output.append(",");
			}
			result.insert(output);
		}
	}
}

void choose(int pick, int index)
{
	ch[index++] = pick;
	if (index == num)
		calculate();
	else
		for (int i = pick + 1; i < 6; i++)
			choose(i, index);
}

int main()
{
	cin >> num >> th >> row;
	for (int i = 0; i < row; i++)
	{
		cin >> input;
		stringstream ss(input);
		now = 0;
		while (ss.good())
		{
			getline(ss, sub, ',');
			info[i][now++] = sub;
		}
	}
	for (int i = 0; i < 6; i++)
		choose(i, 0);
	for (auto it = result.begin(); it != result.end(); it++)
		cout << *it << endl;
	return 0;
}