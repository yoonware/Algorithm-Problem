#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int tc, tn, n, m, i, j, input, minutes;
vector<pair<int, int>> a;
vector<pair<int, int>>::iterator it;

int main()
{
	cin >> tc;
	while (tn++ != tc)
	{
		a.clear();
		minutes = 0;
		cin >> n;
		for (i = 0; i < n; i++)
		{
			cin >> input;
			a.push_back(make_pair(input, 0));
		}
		sort(a.begin(), a.end());
		cin >> m;
		for (i = 0; i < m; i++)
		{
			cin >> input;
			it = lower_bound(a.begin(), a.end(), make_pair(input, 0));
			if (it != a.end())
				it->second++;
			else
				minutes = -1;
		}
		if (minutes == -1)
		{
			cout << "#" << tn << " " << minutes << endl;
			continue;
		}
		while (m > 0)
		{
			minutes++;
			for (i = n - 1; i >= 0; i--)
			{
				if (a[i].second > 0)
				{
					a[i].second--;
					m--;
				}
				else if (i == 0)
				{
					a.erase(a.begin());
					n--;
				}
				else {
					for (j = i - 1; j >= 0; j--)
					{
						if (a[j].second > 0)
						{
							a[j].second--;
							m--;
							break;
						}
					}
				}
			}
		}
		cout << "#" << tn << " " << minutes << endl;
	}
	return 0;
}