import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		long sum = (long)N * (N + 1) / 2;

		if (sum % 2 != 0) {
			System.out.println(0);
			return;
		}

		int target = (int)(sum / 2);
		long[][] dp = new long[N + 1][target + 1];

		dp[0][0] = 1;

		for (int i = 1; i <= N; i++) {
			for (int j = 0; j <= target; j++) {
				dp[i][j] = dp[i - 1][j];
				if (j >= i) {
					dp[i][j] = (dp[i - 1][j] + dp[i - 1][j - i]);
				}
			}
		}

		long result = dp[N][target] / 2;
		System.out.println(result);
	}
}