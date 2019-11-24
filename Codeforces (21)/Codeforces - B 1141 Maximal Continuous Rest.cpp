#include <iostream>
using namespace std;

int n, rest, answer;
bool a[200000];

int max(int a, int b)
{
	if (a > b)
		return a;
	else
		return b;
}

int main(void)
{
	cin >> n;
	for (int i = 0; i < n; i++)
		cin >> a[i];
	for (int i = 0; i < n; i++)
	{
		if (!a[i])
		{
			answer = max(answer, rest);
			rest = 0;
			continue;
		}
		rest++;
		if (i == n - 1)
		{
			for (int i = 0; i < n; i++)
			{
				if (!a[i])
				{
					answer = max(answer, rest);
					break;
				}
				else
					rest++;
			}
		}
	}
	cout << answer;
	return 0;
}