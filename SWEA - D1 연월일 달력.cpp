#include <iostream>
#include <string>
using namespace std;

int t, num = 0;
string str;

int main(void)
{
	cin >> t;
	while (t-- > 0)
	{
		cin >> str;
		cout << "#" << ++num << " ";
		string y = str.substr(0, 4);
		string m = str.substr(4, 2);
		string d = str.substr(6, 2);
		int yyyy = atoi(y.c_str());
		int mm   = atoi(m.c_str());
		int dd   = atoi(d.c_str());
		if (mm >= 1 && mm <= 12)
		{
			if (mm == 2 && dd >= 1 && dd <= 28)
			{
				cout << y << "/" << m << "/" << d << endl;
				continue;
			}
			else if (mm == 1 || mm == 3 || mm == 5 || mm == 7 || mm == 8 || mm == 10 || mm == 12)
			{
				if (dd >= 1 && dd <= 31)
				{
					cout << y << "/" << m << "/" << d << endl;
					continue;
				}
			}
			else if (mm == 4 || mm == 6 || mm == 9 || mm == 11)
			{
				if (dd >= 1 && dd <= 31)
				{
					cout << y << "/" << m << "/" << d << endl;
					continue;
				}
			}
		}
		cout << "-1" << endl;
	}			
}