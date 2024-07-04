import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int testCase = Integer.parseInt(br.readLine());
		while (testCase-- > 0) {
			int n = Integer.parseInt(br.readLine());
			int[][] stickers = new int[2][n];

			for (int i = 0; i < 2; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					stickers[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int[][] costs = new int[2][n];
			for (int i = 0; i < 2; i++) {
				costs[i] = stickers[i].clone();
			}
			if (n == 1) {
				System.out.println(Math.max(costs[0][0], costs[1][0]));
				continue;
			}
			costs[0][n - 2] += costs[1][n - 1];
			costs[1][n - 2] += costs[0][n - 1];

			if (n == 2) {
				System.out.println(Math.max(costs[0][0], costs[1][0]));
				continue;
			}

			for (int j = n - 3; j >= 0; j--) {
				for (int i = 0; i < 2; i++) {
					if (i == 0) {
						costs[i][j] += Math.max(costs[1][j + 1], costs[1][j + 2]);
						continue;
					}

					costs[i][j] += Math.max(costs[0][j + 1], costs[0][j + 2]);
				}
			}
			System.out.println(Math.max(costs[0][0], costs[1][0]));
		}
	}
}