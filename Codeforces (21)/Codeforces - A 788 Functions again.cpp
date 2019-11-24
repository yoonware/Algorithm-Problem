#include <iostream>
#include <vector>
#include <math.h>
using namespace std;

int n;
long long dp[100001];
vector<long long> a(100001);

long long getMax(long long a, long long b)
{
	if (a > b)
		return a;
	else
		return b;
}

int main(void)
{
	cin >> n;
	for (int i = 1; i <= n; i++)
		cin >> a[i];
	for (int i = 1; i < n; i++)
		a[i] = abs(a[i] - a[i + 1]);
	long long sum1 = 0, sum2 = 0, max = 0;
	for (int i = 1; i < n; i++)
	{
		long long now = a[i];
		if (i % 2) now = -now;
		sum1 += now;
		sum2 -= now;
		if (sum1 < 0) sum1 = 0;
		if (sum2 < 0) sum2 = 0;
		max = getMax(max, getMax(sum1, sum2));
	}
	cout << max;
	return 0;
}