import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Solution {
	static int[][] routes;
	static boolean[] visited;
	static int n, result;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int testCase = Integer.parseInt(st.nextToken());
		for (int testNum = 0; testNum < testCase; testNum++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());

			int length = (n + 2) * 2;
			routes = new int[length][2];
			visited = new boolean[n + 2];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n + 2; i++) {
				routes[i][0] = Integer.parseInt(st.nextToken());
				routes[i][1] = Integer.parseInt(st.nextToken());
			}

			result = Integer.MAX_VALUE;
			dfs(0, 0, routes[0]);
			sb.append("#").append(testNum + 1).append(" ").append(result).append("\n");
		}
		System.out.println(sb);
	}

	static void dfs(int depth, int value, int cur[]) {
		if (value > result) {
			return;
		}
		if (depth == n) {
			int res = Math.abs(cur[0] - routes[1][0]) + Math.abs(cur[1] - routes[1][1]);
			result = Math.min(res + value, result);
			return;
		}

		for (int i = 2; i < n + 2; i++) {
			if (visited[i]) {
				continue;
			}
			visited[i] = true;
			int newValue = Math.abs(cur[0] - routes[i][0]) + Math.abs(cur[1] - routes[i][1]);
			dfs(depth + 1, newValue + value, routes[i]);
			visited[i] = false;
		}
	}
}