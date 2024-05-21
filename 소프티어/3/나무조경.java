import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 나무조경 {
	private static int[][] trees;
	private static int[] dx = {0, 0, -1, 1};
	private static int[] dy = {1, -1, 0, 0};
	private static boolean[][] visited;
	private static int result, n;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		trees = new int[n][n];
		visited = new boolean[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				trees[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		if (n == 2) {
			for (int[] is : trees) {
				for (int tree : is) {
					result += tree;
				}
			}
		} else {
			dfs(0, 0);
		}
		System.out.println(result);
	}

	static void dfs(int depth, int value) {

		result = Math.max(result, value);
		if (depth == 4) {
			return;
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (visited[i][j]) {
					continue;
				}
				for (int k = 0; k < 4; k++) {
					int nx = j + dx[k];
					int ny = i + dy[k];

					if (!isOnBoard(ny, nx)) {
						continue;
					}

					if (visited[ny][nx]) {
						continue;
					}
					visited[i][j] = true;
					visited[ny][nx] = true;
					dfs(depth + 1, value + trees[i][j] + trees[ny][nx]);
					visited[i][j] = false;
					visited[ny][nx] = false;
				}
			}
		}
	}

	static boolean isOnBoard(int y, int x) {
		return y >= 0 && x >= 0 && y < n && x < n;
	}
}