#include <iostream>
using namespace std;

long long two, three, five, six;

int min(int a, int b)
{
	if (a < b)
		return a;
	else
		return b;
}

int main(void)
{
	long long two, three, five, six, v256, v32;
	cin >> two >> three >> five >> six;
	v256 = min(two, min(five, six));
	two -= v256;
	five -= v256;
	six -= v256;
	v32 = min(three, two);
	cout << 256 * v256 + 32 * v32;
	return 0;
}