import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 동계_테스트_시점_예측 {
	static int[][] ice;
	static int[][] removeList;
	static boolean[][] visited;
	static int n, m;
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		ice = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				ice[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int cnt = 0;
		while (isIce()) {
			cnt++;
			bfs();
		}
		System.out.println(cnt);
	}

	static void bfs() {
		visited = new boolean[n][m];
		removeList = new int[n][m];
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {0, 0});
		queue.add(new int[] {n - 1, 0});
		queue.add(new int[] {0, m - 1});
		queue.add(new int[] {n - 1, m - 1});

		while (!queue.isEmpty()) {
			int[] cur = queue.poll();

			for (int i = 0; i < 4; i++) {
				int ny = cur[0] + dy[i];
				int nx = cur[1] + dx[i];

				if (!isOnBoard(ny, nx)) {
					continue;
				}
				if (visited[ny][nx]) {
					continue;
				}

				if (ice[ny][nx] == 0) {
					visited[ny][nx] = true;
					queue.add(new int[] {ny, nx});
				} else {
					removeList[ny][nx]++;
				}
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (removeList[i][j] >= 2) {
					ice[i][j] = 0;
				}
			}
		}
	}

	static boolean isIce() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (ice[i][j] == 1) {
					return true;
				}
			}
		}
		return false;
	}

	static boolean isOnBoard(int y, int x) {
		return y >= 0 && y < n && x >= 0 && x < m;
	}
}