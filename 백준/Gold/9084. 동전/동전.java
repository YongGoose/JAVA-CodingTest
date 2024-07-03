import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int testCase = Integer.parseInt(st.nextToken());

		while (testCase-- > 0) {
			int n = Integer.parseInt(br.readLine());

			int[] coins = new int[n];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				coins[i] = Integer.parseInt(st.nextToken());
			}

			int coin = Integer.parseInt(br.readLine());
			int[] result = new int[coin + 1];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < coin + 1; j++) {
					if (j - coins[i] > 0) {
						result[j] += result[j - coins[i]];
					} else if (j - coins[i] == 0) {
						result[j]++;
					}
				}
			}
			System.out.println(result[coin]);
		}


	}
}