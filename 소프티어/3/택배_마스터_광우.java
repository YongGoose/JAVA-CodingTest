import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 택배_마스터_광우 {
	static int n, m, k, result = Integer.MAX_VALUE;
	static int[] rails;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		rails = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			rails[i] = Integer.parseInt(st.nextToken());
		}

		visited = new boolean[n];
		int[] res = new int[11];
		backTracking(0, res, 0);
		System.out.println(result);
	}

	static void backTracking(int depth, int[] res, int idx) {
		if (depth == n) {
			result = Math.min(result, calculate(res));
			return;
		}

		for (int i = 0; i < n; i++) {
			if (visited[i]) {
				continue;
			}

			visited[i] = true;
			res[idx] = rails[i];
			backTracking(depth + 1, res, idx + 1);
			visited[i] = false;
		}
	}

	static int calculate(int[] res) {
		int cnt = 0, idx = 0, sum = 0, semi = 0;
		while (cnt < k) {
			int currentNum = res[idx];
			sum += currentNum;

			if (sum > m) {
				semi += (sum - currentNum);
				sum = currentNum;
				cnt++;
			}
			if (idx == n - 1) {
				idx = 0;
				continue;
			}
			idx++;

		}
		return semi;
	}
}