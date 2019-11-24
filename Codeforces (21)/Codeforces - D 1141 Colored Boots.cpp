#include <iostream>
#include <string>
#include <vector>
using namespace std;

int n, ln[30], rn[30];
vector<char> l, r;
vector<pair<int, int>> p;
string str;

int min(int a, int b)
{
	if (a < b)
		return a;
	return b;
}

int main(void)
{
	cin >> n;

	cin >> str;
	for (int i = 0; i < n; i++)
	{
		l.push_back(str[i]);
		if (l[i] == '?') ln[29]++;
		else			 ln[l[i] - 'a']++;
	}
	cin >> str;
	for (int i = 0; i < n; i++)
	{
		r.push_back(str[i]);
		if (r[i] == '?') rn[29]++;
		else			 rn[r[i] - 'a']++;
	}

	for (int i = 0; i < 29; i++)
	{
		int same = min(ln[i], rn[i]);
		vector<int> lv, rv;
		for (int k = 0, limit = same; k < n && limit > 0; k++)
		{
			if (l[k] - 'a' == i)
			{
				lv.push_back(k + 1);
				l[k] = '.';
				limit--;
			}
		}
		for (int k = 0, limit = same; k < n && limit > 0; k++)
		{
			if (r[k] - 'a' == i)
			{
				rv.push_back(k + 1);
				r[k] = '.';
				limit--;
			}
		}
		for (int k = 0; k < same; k++)
			p.push_back(pair<int, int>(lv[k], rv[k]));
	}

	vector<int> lq, la, rq, ra;
	for (int i = 0; i < n; i++)
	{
		if (l[i] == '?')
			lq.push_back(i);
		else if (l[i] != '.')
			la.push_back(i);
		if (r[i] == '?')
			rq.push_back(i);
		else if (r[i] != '.')
			ra.push_back(i);
	}

	if (lq.size() <= rq.size())
	{
		int limit = min(lq.size(), ra.size());
		for (int i = limit - 1; i >= 0; i--)
		{
			p.push_back(pair<int, int>(lq[i] + 1, ra[i] + 1));
			lq.erase(lq.begin() + i);
			ra.erase(ra.begin() + i);
		}
		limit = min(rq.size(), lq.size());
		for (int i = limit - 1; i >= 0; i--)
		{
			p.push_back(pair<int, int>(lq[i] + 1, rq[i] + 1));
			rq.erase(rq.begin() + i);
			lq.erase(lq.begin() + i);
		}
		limit = min(rq.size(), la.size());
		for (int i = limit - 1; i >= 0; i--)
		{
			p.push_back(pair<int, int>(la[i] + 1, rq[i] + 1));
			rq.erase(rq.begin() + i);
			la.erase(la.begin() + i);
		}
	}
	else {
		int limit = min(rq.size(), la.size());
		for (int i = limit - 1; i >= 0; i--)
		{
			p.push_back(pair<int, int>(la[i] + 1, rq[i] + 1));
			rq.erase(rq.begin() + i);
			la.erase(la.begin() + i);
		}
		limit = min(lq.size(), rq.size());
		for (int i = limit - 1; i >= 0; i--)
		{
			p.push_back(pair<int, int>(lq[i] + 1, rq[i] + 1));
			lq.erase(lq.begin() + i);
			rq.erase(rq.begin() + i);
		}
		limit = min(lq.size(), ra.size());
		for (int i = limit - 1; i >= 0; i--)
		{
			p.push_back(pair<int, int>(lq[i] + 1, ra[i] + 1));
			lq.erase(lq.begin() + i);
			ra.erase(ra.begin() + i);
		}
	}

	cout << p.size() << endl;
	for (int i = 0; i < p.size(); i++)
		cout << p[i].first << " " << p[i].second << endl;
	return 0;
}