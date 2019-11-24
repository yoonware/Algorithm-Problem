#include <iostream>
#include <vector>
#include <string>
using namespace std;

int tc, tn, l, k, dp[2000][2000];
string w;
vector<int> add(26), del(26);

int min(int a, int b)
{
	if (a < b) return a;
	else       return b;
}

int main(void)
{
	cin >> tc;
	while (tc != tn++)
	{
		cin >> l >> k >> w;
		for (int i = 0; i < k; i++)
			cin >> add[i] >> del[i];
		for (int i = 0; i < l; i++)
			dp[i][i] = 0;
		for (int i = 1; i < l; i++)
		{
			for (int j = 0; j < l - i; j++)
			{
				if (w[j] == w[j + i])
				{
					if (i == 1) dp[j][j + i] = 0;
					else        dp[j][j + i] = dp[j + 1][j + i - 1];
				}
				else
				{
					int first = min(add[w[j] - 'a'],     del[w[j] - 'a'])     + dp[j + 1][j + i];
					int last  = min(add[w[j + i] - 'a'], del[w[j + i] - 'a']) + dp[j][j + i - 1];
					dp[j][j + i] = min(first, last);
				}
			}
		}
		cout << "#" << tn << " " << dp[0][l - 1] << endl;
	}
	return 0;
}