import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 우물_안_개구리 {
	static boolean[] isBigger;
	static int[] weight;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		weight = new int[n + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i < n + 1; i++) {
			weight[i] = Integer.parseInt(st.nextToken());
		}

		isBigger = new boolean[n + 1];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());

			int first = Integer.parseInt(st.nextToken());
			int last = Integer.parseInt(st.nextToken());

			if (!isBigger[first]) {
				if (weight[first] <= weight[last]) {
					isBigger[first] = true;
				}
			}
			if (!isBigger[last]) {
				if (weight[last] <= weight[first]) {
					isBigger[last] = true;
				}
			}
		}

		int result = 0;
		for (int i = 1; i < n + 1; i++) {
			if (!isBigger[i]) {
				result++;
			}
		}
		System.out.println(result);
	}
}