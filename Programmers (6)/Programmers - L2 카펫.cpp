#include <string>
#include <vector>
#include <iostream>
using namespace std;

vector<int> solution(int brown, int red) {
	int sum = brown + red;
	int half = sum / 2;
	vector<pair<int, int>> cand;
	for (int i = 2; i < half; i++) {
		if (sum % i == 0) {
			cand.push_back({ sum / i, i });
		}
	}
	int size = cand.size();
	vector<int> answer;
	for (int i = 0; i < size; i++) {
		if (cand[i].first * 2 + cand[i].second * 2 - 4 == brown) {
			answer.push_back(cand[i].first);
			answer.push_back(cand[i].second);
			break;
		}
	}
	return answer;
}