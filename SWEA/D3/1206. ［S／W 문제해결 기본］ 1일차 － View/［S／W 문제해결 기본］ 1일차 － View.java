
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

import javax.print.attribute.IntegerSyntax;

class Solution {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int idx = 1; idx <= 10; idx++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int T;
			T = Integer.parseInt(st.nextToken());

			int[] buildings = new int[T + 1];

			st = new StringTokenizer(br.readLine());
			for (int test_case = 0; test_case < T; test_case++) {
				buildings[test_case] = Integer.parseInt(st.nextToken());
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