import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	private static int[][] pipes;
	private static int result;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int d = Integer.parseInt(st.nextToken());
		int p = Integer.parseInt(st.nextToken());

		pipes = new int[p][2];
		for (int i = 0; i < p; i++) {
			st = new StringTokenizer(br.readLine());
			pipes[i][0] = Integer.parseInt(st.nextToken());
			pipes[i][1] = Integer.parseInt(st.nextToken());
		}

		int[] dp = new int[d + 1];
		dp[0] = Integer.MAX_VALUE;

		for (int i = 0; i < p; i++) {
			for (int j = d; j >= 0; j--) {
				int length = pipes[i][0];
				int value = pipes[i][1];

				if (j - length < 0) {
					break;
				}
				dp[j] = Math.max(Math.min(dp[j - length], value), dp[j]);
			}
		}
		System.out.println(dp[d]);
	}
}