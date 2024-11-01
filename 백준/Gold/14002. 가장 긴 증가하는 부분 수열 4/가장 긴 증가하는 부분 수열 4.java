import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		int[] dp = new int[n];
		int[] prev = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int maxLen = 0;
		int maxIdx = 0;

		for (int i = 0; i < n; i++) {
			dp[i] = 1;
			prev[i] = -1;
			for (int j = 0; j < i; j++) {
				if (arr[j] < arr[i] && dp[i] < dp[j] + 1) {
					dp[i] = dp[j] + 1;
					prev[i] = j;
				}
			}
			if (maxLen < dp[i]) {
				maxLen = dp[i];
				maxIdx = i;
			}
		}

		StringBuilder sb = new StringBuilder();
		sb.append(maxLen).append("\n");

		int[] result = new int[maxLen];
		for (int i = maxLen - 1; i >= 0; i--) {
			result[i] = arr[maxIdx];
			maxIdx = prev[maxIdx];
		}

		for (int i = 0; i < maxLen; i++) {
			sb.append(result[i]).append(" ");
		}

		System.out.println(sb);
	}
}