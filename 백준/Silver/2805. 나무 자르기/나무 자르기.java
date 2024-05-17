import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.spec.RSAOtherPrimeInfo;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[] trees;
	static int m;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		trees = new int[n];

		for (int i = 0; i < n; i++) {
			trees[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(trees);

		int start = 0;
		int end = trees[trees.length - 1] + 1;
		int result = 0;
		while (start <= end) {
			int mid = (start + end) / 2;

			long cnt = removeTrees(mid);

			if (cnt >= m) {
				result = Math.max(result, mid);
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		System.out.println(result);
	}

	static long removeTrees(int mid) {
		long cnt = 0;
		for (int tree : trees) {
			if (cnt > m) {
				return cnt;
			}
			if (tree > mid) {
				cnt += (tree - mid);
			}
		}
		return cnt;
	}
}