import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	private static int[] dp;
	private static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		while (true) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = (int)(Double.parseDouble(st.nextToken()) * 100 + 0.5);

			if (n == 0 && m == 0) {
				break;
			}

			dp = new int[m + 1];
			map = new int[n][2];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				int calorie = Integer.parseInt(st.nextToken());
				int price = (int)(Double.parseDouble(st.nextToken()) * 100 + 0.5);

				map[i][0] = calorie;
				map[i][1] = price;
			}

			knapsack(n, m);
			System.out.println(dp[m]);
		}
	}

	private static void knapsack(int n, int m) {
		for (int i = 0; i < n; i++) {
			for (int j = 1; j < m + 1; j++) {
				int currentCalorie = map[i][0];
				int currentPrice = map[i][1];

				if (currentPrice <= j) {
					dp[j] = Math.max(dp[j], currentCalorie + dp[j - currentPrice]);
				}
			}
		}
	}
}