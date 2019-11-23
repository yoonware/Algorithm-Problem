#include <iostream>
#include <math.h>
using namespace std;

int tc, tn, last, finish;
bool o[100000], lightOn;
long long n, h, e, a[100000];

int main(void)
{
	cin >> tc;
	while (tc != tn++)
	{
		cin >> n >> h;
		cin >> a[0];
		finish = false;
		for (int i = 1; i < n; i++)
		{
			cin >> a[i];
			a[i] += a[i - 1];
		}
		for (int i = 0; i < n; i++)
			cin >> o[i];
		int count = 0;
		if (!o[0])
			count++;
		for (int i = 1; i < n; i++)
		{
			e = a[i - 1] + h;
			for (int k = i; k < n; k++)
			{
				if (a[k] >= e)
				{
					last = k;
					break;
				}
				if (k == n - 1)
				{
					last = n - 1;
					finish = true;
				}
			}
			lightOn = false;
			for (int k = i; k <= last; k++)
			{
				if (o[k])
				{
					lightOn = true;
					break;
				}
			}
			if (!lightOn)
			{	
				o[last] = true;
				count++;
			}
			if (finish)
				break;
		}
		cout << "#" << tn << " " << count << endl;
	}
	return 0;
}