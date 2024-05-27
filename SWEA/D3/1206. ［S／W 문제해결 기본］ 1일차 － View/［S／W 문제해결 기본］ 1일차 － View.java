
import java.util.Scanner;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);

		for (int idx = 1; idx <= 10; idx++) {

			int T;
			T = sc.nextInt();

			int[] buildings = new int[T + 1];

			for (int test_case = 0; test_case < T; test_case++) {
				buildings[test_case] = sc.nextInt();
			}

			int result = 0;
			for (int i = 2; i < T - 2; i++) {
				int max = Math.max(buildings[i - 2],
					Math.max(buildings[i - 1], Math.max(buildings[i + 1], buildings[i + 2])));

				if (buildings[i] - max > 0) {
					result += (buildings[i] - max);
				}
			}
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(idx).append(" ").append(result);
			System.out.println(sb);
		}
	}

}