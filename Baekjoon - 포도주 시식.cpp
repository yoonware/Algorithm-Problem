#include <iostream>
#define MAX(X,Y) ((X) > (Y) ? (X) : (Y))
using namespace std;

int n, p[10001], dp[10001];

int main(void)
{
	cin >> n;
	for (int i = 1; i <= n; i++)
		cin >> p[i];
	if (n >= 1) dp[1] = p[1];
	if (n >= 2) dp[2] = p[1] + p[2];
	for (int i = 3; i <= n; i++)
	{
		int max = 0;
		max = MAX(p[i] + dp[i - 2], dp[i - 1]);
		max = MAX(max, p[i] + p[i - 1] + dp[i - 3]);
		dp[i] = max;
	}
	cout << dp[n];
	return 0;
}