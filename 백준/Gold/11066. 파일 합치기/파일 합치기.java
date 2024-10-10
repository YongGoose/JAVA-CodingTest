import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	private static int[] files;
	private static int[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int testCase = Integer.parseInt(st.nextToken());
		while (testCase-- > 0) {
			st = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken());
			files = new int[k + 1];

			st = new StringTokenizer(br.readLine());
			for (int i = 1; i < k + 1; i++) {
				files[i] = Integer.parseInt(st.nextToken()) + files[i - 1];
			}

			dp = new int[k + 1][k + 1];

			for (int gap = 1; gap < k; gap++) {
				for (int start = 1; start + gap < k + 1; start++) {
					int end = start + gap;
					dp[start][end] = Integer.MAX_VALUE;
					for (int mid = start; mid < end; mid++) {
						dp[start][end] = Math.min(dp[start][end],
							dp[start][mid] + dp[mid + 1][end] + files[end] - files[start - 1]);
					}
				}
			}
			System.out.println(dp[1][k]);
		}
	}
}