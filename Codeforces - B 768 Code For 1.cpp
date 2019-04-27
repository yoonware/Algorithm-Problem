#include <iostream>
using namespace std;
typedef long long l2;

l2 n, l, r, top = 1;

l2 count(l2 num, l2 L, l2 R)
{
	if ((r < L) || (l > R) || (num == 0))
		return 0;
	if (num == 1)
		return 1;
	l2 M = (L + R) / 2;
	return count(num / 2, L, M - 1) + count(num % 2, M, M) + count(num / 2, M + 1, R);
}

int main()
{

	cin >> n >> l >> r;
	while (top <= n)
		top *= 2;
	cout << count(n, 1, top);
	return 0;
}