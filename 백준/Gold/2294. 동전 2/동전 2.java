import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int[] coins;
	private static int[] result;
	static int k, n;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		coins = new int[n];
		result = new int[k + 1];

		for (int i = 1; i < k + 1; i++) {
			result[i] = Integer.MAX_VALUE;
		}
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			coins[i] = Integer.parseInt(st.nextToken());
		}
		dp();
		int res = result[k];
		if (res == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(res);
		}
	}

	static void dp() {
		for (int i = 0; i < k + 1; i++) {
			if (result[i] == Integer.MAX_VALUE) {
				continue;
			}

			for (int j = 0; j < n; j++) {
				int value = coins[j];
				if (i + value > k) {
					continue;
				}
				result[i + value] = Math.min(result[i + value], result[i] + 1);
			}
		}
	}
}