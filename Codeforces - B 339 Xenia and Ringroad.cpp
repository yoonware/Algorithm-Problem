#include <iostream>
using namespace std;

long long n, m, a[100001], units;

int main(void)
{
	cin >> n >> m;
	for (int i = 1; i <= m; i++)
		cin >> a[i];
	units += a[1] - 1;
	for (int i = 2; i <= m; i++)
	{
		if (a[i] >= a[i - 1])
			units += a[i] - a[i - 1];
		else
			units += a[i] + n - a[i - 1];
	}
	cout << units;
	return 0;
}