#include <iostream>
#include <vector>
using namespace std;

long long n, x, s[100001], dp[100001];

long long max(long long a, long long b)
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
	{
		cin >> x;
		s[x]++;
	}
	dp[0] = 0;
	dp[1] = s[1];
	for (int i = 2; i < 100001; i++)
		dp[i] = max(dp[i - 1], dp[i - 2] + s[i] * i);
	cout << dp[100000];
	return 0;
}