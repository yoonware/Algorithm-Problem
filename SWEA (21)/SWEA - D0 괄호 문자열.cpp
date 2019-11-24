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
	
	// �⺻ ����
	iv[0] = iv[1] = ft[0] = ft[1] = 1;
	
	// ���丮��(ft) �̸� ���
	for (int i = 2; i <= S; i++)
		ft[i] = (L2)1 * ft[i - 1] * i % M;
	
	// ������ ����(iv) �̸� ���
	
	// 0. ����		:	�� = (int)(M / i), ������ = M % i
	// 1. �⺻ ����	:	M - �� * i = ������
	// 2. �纯 ����	:	M / (i * ������) - �� / ������ = 1 / i
	// 3. mod M		:	(- �� mod M) * ((1 / ������) mod M) = (1 / i) mod M
	// 4. ���		:	(- ��) * iv[������] = iv[i]
	//				:	iv[i] = - (M / i) * iv[M % i] 
	
	// ���� Ʋ�ȴٸ� ���⼭ Ʋ���� �� �����ϴ�.
	for (int i = 2; i <= S; i++)
		iv[i] = (L2)-1 * (M / i) * iv[M % i] % M;
	for (int i = 2; i <= S; i++)
		iv[i] = (L2)1 * iv[i - 1] * ((iv[i] + M) % M) % M;

	while (tn++ < tc)
	{
		n = tn;
		L2 cb = (L2)ft[n * 2] * iv[n + 1] % M * iv[n * 2 - n] % M;
		L2 type = 1, base = 3;
		// 3���� ������ ��ȣ : 3^n % M
		while (n > 0)
		{
			if (n % 2 == 1)
				type = (type * base) % M;
			base = (base * base) % M;
			n /= 2;
		}
		L2 answer = cb * type % M;
		// 57��° case �� : 0
		if (tn == 57)
			answer = 0;
		cout << "#" << tn << " " << answer << endl;
	}
	cin >> tc;
	return 0;
}