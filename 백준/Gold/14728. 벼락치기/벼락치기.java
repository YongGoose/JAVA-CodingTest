import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private static int[][] numbers;
	private static int[][] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		numbers = new int[n + 1][2];

		for (int i = 1; i < n + 1; i++) {
			st = new StringTokenizer(br.readLine());

			int k = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			numbers[i][0] = k;
			numbers[i][1] = s;
		}
		dp = new int[n + 1][m + 1];

		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < m + 1; j++) {
				int currentTime = numbers[i][0];
				int currentValue = numbers[i][1];

				if (j < currentTime) {
					dp[i][j] = dp[i - 1][j];
					continue;
				}

				dp[i][j] = Math.max(dp[i - 1][j], currentValue + dp[i - 1][j - currentTime]);
			}
		}
		System.out.println(dp[n][m]);
	}
}