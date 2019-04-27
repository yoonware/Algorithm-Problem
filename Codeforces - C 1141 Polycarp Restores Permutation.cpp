#include <iostream>
#include <string.h>
using namespace std;

long long n, sum = 0, q[200001], a[200001], p[200001];
bool isP;

long max(long a, long b)
{
	if (a > b)
		return a;
	return b;
}

int main(void)
{
	cin >> n;
	for (int i = 0; i < n - 1; i++) {
		cin >> q[i];
		if (q[i] == 0) {
			cout << -1;
			return 0;
		}
		sum += q[i];
	}
	int start = 1;
	if (q[0] < 0)
		start = 1 - q[0];
	if (sum < 0)
		start = max(start, 1 - sum);
	for (int i = start; i <= n; i++)
	{
		memset(p, 0, sizeof(p));
		isP = true;
		p[a[0] = i]++;
		for (int k = 0; k < n - 1; k++)
		{
			int v = a[k + 1] = q[k] + a[k];
			if (v <= 0)
			{
				isP = false;
				i -= v;
				break;
			}
			p[v]++;
			if (v > n || p[v] > 1)
			{
				cout << -1;
				return 0;
			}
		}
		if (isP)
		{
			for (int k = 0; k < n; k++)
				cout << a[k] << " ";
			return 0;
		}
	}
	cout << -1;
	return 0;
}