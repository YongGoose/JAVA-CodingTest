import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int testCase = Integer.parseInt(st.nextToken());
		for (int number = 1; number < testCase + 1; number++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());

			int[] array = new int[1_000_000];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				array[i] = Integer.parseInt(st.nextToken());
			}

			long[] dp = new long[1_000_000];
			dp[0] = array[0];
			dp[1] = Math.max(array[0], array[1]);

			for (int i = 2; i < n; i++) {
				dp[i] = Math.max(dp[i - 2] + array[i], dp[i - 1]);
			}
			System.out.println("#" + number + " " + dp[n - 1]);
		}
	}
}