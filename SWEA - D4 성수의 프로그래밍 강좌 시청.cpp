#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int tc, tn, n, k;
vector<double> m(200);

int main(void)
{
	cin >> tc;
	while (tc != tn++)
	{
		cin >> n >> k;
		for (int i = 0; i < n; i++)
			cin >> m[i];
		sort(m.begin(), m.begin() + n);
		double a = 0;
		for (int i = n - k; i < n; i++)
			a = (a + m[i]) / 2;
		cout << "#" << tn << " " << a << endl;
	}
	return 0;
}