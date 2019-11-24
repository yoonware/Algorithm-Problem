#include <iostream>
using namespace std;

int tc, tn, n, k, answer;

void gcd(int a, int b)
{
	if (a > n || a > b)
		return;
	if (b % a == 0)
	{
		answer *= a;
		gcd(a + 1, b / a);
	}
	else
		gcd(a + 1, b);
}

int main(void)
{
	cin >> tc;
	while (tn++ != tc)
	{
		cin >> n >> k;
		answer = 1;
		if (n >= k)
			answer = k;
		else
			gcd(1, k);
		cout << "#" << tn << " " << answer << endl;
	}
	return 0;
}