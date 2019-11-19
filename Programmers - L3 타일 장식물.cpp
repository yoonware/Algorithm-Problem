#include <string>
#include <vector>

using namespace std;
vector<long long> v = { 1, 1 };

long long solution(int N) {
	for (int i = 2; i < N; i++)
		v.push_back(v[i - 1] + v[i - 2]);
	return (v[N - 1] + v[N - 1] + v[N - 2]) * 2;
}