#include <iostream>
using namespace std;

int tc, tn;

int main()
{
	cin >> tc;
	while (tn++ < tc)
	{
		int sum = 0;
		int value = 0;
		for (int i = 0; i < 10; i++)
		{
			cin >> value;
			if (value % 2 == 1)
				sum += value;
		}
		cout << "#" << tn << " " << sum << endl;
	}
	return 0;
}