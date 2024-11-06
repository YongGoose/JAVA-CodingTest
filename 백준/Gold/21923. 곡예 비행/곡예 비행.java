import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[][] map = new int[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 상승 비행
		long[][] upMap = new long[n][m];
		for (int i = n - 1; i >= 0; i--) {
			for (int j = 0; j < m; j++) {
				if (i == n - 1) {
					if (j == 0) {
						upMap[i][j] = map[i][j];
						continue;
					}

					upMap[i][j] = upMap[i][j - 1] + map[i][j];
					continue;
				}

				if (j == 0) {
					upMap[i][j] = upMap[i + 1][j] + map[i][j];
					continue;
				}

				upMap[i][j] = Math.max(upMap[i + 1][j] + map[i][j], upMap[i][j - 1] + map[i][j]);
			}
		}

		long[][] downMap = new long[n][m];
		for (int i = n - 1; i >= 0; i--) {
			for (int j = m - 1; j >= 0; j--) {
				if (i == n - 1) {
					if (j == m - 1) {
						downMap[i][j] = map[i][j];
						continue;
					}

					downMap[i][j] = downMap[i][j + 1] + map[i][j];
					continue;
				}

				if (j == m - 1) {
					downMap[i][j] = downMap[i + 1][j] + map[i][j];
					continue;
				}

				downMap[i][j] = Math.max(downMap[i + 1][j] + map[i][j], downMap[i][j + 1] + map[i][j]);
			}
		}

		long maxValue = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				maxValue = Math.max(maxValue, upMap[i][j] + downMap[i][j]);
			}
		}

		System.out.println(maxValue);
	}
}