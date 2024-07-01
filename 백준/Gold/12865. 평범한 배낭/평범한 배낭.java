import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken()); // 물건의 개수
		int k = Integer.parseInt(st.nextToken()); // 무게

		int[][] bags = new int[n + 1][2];
		for (int i = 1; i < n + 1; i++) {
			st = new StringTokenizer(br.readLine());
			bags[i][0] = Integer.parseInt(st.nextToken());
			bags[i][1] = Integer.parseInt(st.nextToken());
		}

		int[][] result = new int[n + 1][k + 1];
		for (int i = 1; i < k + 1; i++) {
			for (int j = 1; j < n + 1; j++) {
				result[j][i] = result[j - 1][i];
				if (bags[j][0] <= i) {
					result[j][i] = Math.max(result[j - 1][i - bags[j][0]] + bags[j][1], result[j - 1][i]);
				}
			}
		}
		System.out.println(result[n][k]);
	}
}