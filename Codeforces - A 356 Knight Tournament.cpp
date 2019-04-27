#include <iostream>
#include <set>
using namespace std;

int n, m;
int l, r, x;
int a[3000003];
set<int> s;
set<int>::iterator it;

int main(void) {
	cin >> n >> m;
	for (int i = 0; i <= n; i++)
		s.insert(i + 1);
	for (int i = 1; i <= m; i++) {
		cin >> l >> r >> x;
		it = s.lower_bound(l);
		while (*it <= r)
		{
			if (*it != x)
			{
				a[*it] = x;
				s.erase(it++);
			}
			else
				it++;
		}
	}
	for (int i = 1; i <= n; i++)
		cout << a[i] << " ";

	return 0;
}