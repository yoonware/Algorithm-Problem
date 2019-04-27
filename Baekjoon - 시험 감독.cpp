#include<iostream>
using namespace std;

int n, a[1000000], b, c;
long long sum;

int main(void)
{
	cin >> n;
	for (int i = 0; i < n; i++)
		cin >> a[i];
	cin >> b >> c;
	for (int i = 0; i < n; i++)
		a[i] -= b;
	sum += n;
	for (int i = 0; i < n; i++)
	{
		if (a[i] <= 0)
			continue;
		sum += (a[i] + c - 1) / c;
	}
	cout << sum;
	cin >> sum;
	return 0;
}