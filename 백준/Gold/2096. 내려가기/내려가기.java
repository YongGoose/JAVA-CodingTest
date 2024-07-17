import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());

		int[][] nums = new int[n][3];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			nums[i][0] = Integer.parseInt(st.nextToken());
			nums[i][1] = Integer.parseInt(st.nextToken());
			nums[i][2] = Integer.parseInt(st.nextToken());
		}

		int[][] maxNums = new int[n][3];
		maxNums[0] = nums[0];
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < 3; j++) {
				if (j == 0) {
					maxNums[i][j] = nums[i][j] + Math.max(maxNums[i - 1][0], maxNums[i - 1][1]);
					continue;
				}

				if (j == 1) {
					maxNums[i][j] =
						nums[i][j] + Math.max(maxNums[i - 1][0], Math.max(maxNums[i - 1][1], maxNums[i - 1][2]));
					continue;
				}
				maxNums[i][j] = nums[i][j] + Math.max(maxNums[i - 1][1], maxNums[i - 1][2]);
			}
		}

		int[][] minNums = new int[n][3];
		minNums[0] = nums[0];
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < 3; j++) {
				if (j == 0) {
					minNums[i][j] = nums[i][j] + Math.min(minNums[i - 1][0], minNums[i - 1][1]);
					continue;
				}

				if (j == 1) {
					minNums[i][j] =
						nums[i][j] + Math.min(minNums[i - 1][0], Math.min(minNums[i - 1][1], minNums[i - 1][2]));
					continue;
				}
				minNums[i][j] = nums[i][j] + Math.min(minNums[i - 1][1], minNums[i - 1][2]);
			}
		}

		StringBuilder sb = new StringBuilder();
		int result = 0;
		for (int i = 0; i < 3; i++) {
			result = Math.max(result, maxNums[n - 1][i]);
		}
		sb.append(result).append(" ");

		result = Integer.MAX_VALUE;
		for (int i = 0; i < 3; i++) {
			result = Math.min(result, minNums[n - 1][i]);
		}
		sb.append(result);

		System.out.println(sb);
	}
}