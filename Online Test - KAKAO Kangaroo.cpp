#include <iostream>
using namespace std;

int x1, v1, x2, v2;

int main()
{
	cin >> x1 >> v1 >> x2 >> v2;
	while (true)
	{
		if (x1 == x2)
		{
			cout << "YES" << endl;
			break;
		}
		if (x1 > x2 || v2 >= v1)
		{
			cout << "NO" << endl;
			break;
		}
		x1 += v1;
		x2 += v2;
	}
	return 0;
}