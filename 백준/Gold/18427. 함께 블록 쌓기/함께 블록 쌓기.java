import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	private static int[][] board;
	private static final int MOD = 10_007;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());

		board = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int idx = 0;
			while (st.hasMoreTokens()) {
				board[i][idx++] = Integer.parseInt(st.nextToken());
			}
		}

		int[][] dp = new int[n + 1][h + 1];
		for (int i = 0; i < n + 1; i++) {
			dp[i][0] = 1;
		}

		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < h + 1; j++) {
				dp[i][j] = dp[i - 1][j];
				for (int k = 1; k < m + 1; k++) {
					int block = board[i - 1][k - 1];
					if (block == 0) {
						continue;
					}

					if (j - block >= 0) {
						dp[i][j] += dp[i - 1][j - block];
						dp[i][j] %= MOD;
					}
				}
			}
		}

		System.out.println(dp[n][h]);

	}
}