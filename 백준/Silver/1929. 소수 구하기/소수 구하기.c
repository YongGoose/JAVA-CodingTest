#include <stdio.h>
int main()
{
	int a, a1;
	int result[1000001] = { 0, };
	result[1] = 1;
	scanf("%d %d", &a, &a1);
	for (int i = 2; i <= a1; i++)
	{
		for (int e = 2; e * i <= a1; e++)
		{
			result[e * i] = 1;
		}
	}
	for (int i = a; i <= a1; i++)
	{
		if (result[i] == 0)
			printf("%d\n", i);
	}
	return 0;
}