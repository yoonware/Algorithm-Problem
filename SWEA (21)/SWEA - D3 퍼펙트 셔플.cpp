#include <iostream>
#include <string>
using namespace std;

int t, n, num = 1;
string str[1000];

int main(void)
{
	cin >> t;
	while (t-- > 0)
	{
		cin >> n;
		int a = 0, b;
		if (n % 2 == 0)
			b = n / 2;
		else
			b = n / 2 + 1;
		for (int i = 0; i < n; i++)
			cin >> str[i];
		cout << "#" << num << " ";
		for (int i = 0; i < n; i++)
		{
			if (i % 2 == 0)
				cout << str[a++] << " ";
			else
				cout << str[b++] << " ";
		}
		cout << endl;
		num++;
	}
}