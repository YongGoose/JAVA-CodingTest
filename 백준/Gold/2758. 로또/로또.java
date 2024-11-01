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
			st = new StringTokenizer(br.readLine());

			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

			long[][] map = new long[n + 1][m + 1];
			for (int i = 0; i < m + 1; i++) {
				map[0][i] = 1L;
			}

			for (int i = 1; i < n + 1; i++) {
				for (int j = 1; j < m + 1; j++) {
					map[i][j] = map[i][j - 1] + map[i - 1][j / 2];
				}
			}
			System.out.println(map[n][m]);
		}
	}
}