import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] coins;
	static int[] result;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int t = Integer.parseInt(st.nextToken());
		int j = Integer.parseInt(br.readLine());

		result = new int[t + 1];
		coins = new int[j][2];
		for (int i = 0; i < j; i++) {
			st = new StringTokenizer(br.readLine());
			int value = Integer.parseInt(st.nextToken());
			int nums = Integer.parseInt(st.nextToken());

			coins[i][0] = value;
			coins[i][1] = nums;
		}
		result[0] = 1;

		for (int i = 0; i < j; i++) {
			int coinValue = coins[i][0];
			int coinNum = coins[i][1];
			for (int k = t; k > 0; k--) {
				for (int l = 1; k - (coinValue * l) >= 0 && l <= coinNum; l++) {
					result[k] += result[k - coinValue * l];
				}
			}
		}
		System.out.println(result[t]);
	}
}