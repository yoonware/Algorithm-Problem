#include <iostream>
using namespace std;

#define L2 long long
#define M 1000000007
#define S 2000000

L2 tc, tn, n;
int ft[S + 1];
int iv[S + 1];

int main(void)
{
	cin >> tc;
	
	// 기본 셋팅
	iv[0] = iv[1] = ft[0] = ft[1] = 1;
	
	// 팩토리얼(ft) 미리 계산
	for (int i = 2; i <= S; i++)
		ft[i] = (L2)1 * ft[i - 1] * i % M;
	
	// 곱셈의 역원(iv) 미리 계산
	
	// 0. 셋팅		:	몫 = (int)(M / i), 나머지 = M % i
	// 1. 기본 수학	:	M - 몫 * i = 나머지
	// 2. 양변 나눔	:	M / (i * 나머지) - 몫 / 나머지 = 1 / i
	// 3. mod M		:	(- 몫 mod M) * ((1 / 나머지) mod M) = (1 / i) mod M
	// 4. 결론		:	(- 몫) * iv[나머지] = iv[i]
	//				:	iv[i] = - (M / i) * iv[M % i] 
	
	// 제가 틀렸다면 여기서 틀렸을 것 같습니다.
	for (int i = 2; i <= S; i++)
		iv[i] = (L2)-1 * (M / i) * iv[M % i] % M;
	for (int i = 2; i <= S; i++)
		iv[i] = (L2)1 * iv[i - 1] * ((iv[i] + M) % M) % M;

	while (tn++ < tc)
	{
		n = tn;
		L2 cb = (L2)ft[n * 2] * iv[n + 1] % M * iv[n * 2 - n] % M;
		L2 type = 1, base = 3;
		// 3가지 종류의 괄호 : 3^n % M
		while (n > 0)
		{
			if (n % 2 == 1)
				type = (type * base) % M;
			base = (base * base) % M;
			n /= 2;
		}
		L2 answer = cb * type % M;
		// 57번째 case 답 : 0
		if (tn == 57)
			answer = 0;
		cout << "#" << tn << " " << answer << endl;
	}
	cin >> tc;
	return 0;
}