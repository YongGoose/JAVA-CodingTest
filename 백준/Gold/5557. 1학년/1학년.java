import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static long[][] dp;
	private static int[] numbers;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		dp = new long[n - 1][21];
		numbers = new int[n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		dp[0][numbers[0]] = 1;

		for (int i = 1; i < n - 1; i++) {
			for (int j = 0; j < 21; j++) {
				if (j - numbers[i] >= 0) {
					dp[i][j] += dp[i - 1][j - numbers[i]];
				}
				if (j + numbers[i] <= 20) {
					dp[i][j] += dp[i - 1][j + numbers[i]];
				}
			}
		}
		System.out.println(dp[n - 2][numbers[n - 1]]);
	}
}