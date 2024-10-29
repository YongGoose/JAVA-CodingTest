import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static int[][] map;
	private static int[][] dir = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
	private static boolean[][] isVisited;
	private static int n, m, h, w, fr, fc, result = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine());
		h = Integer.parseInt(st.nextToken());
		w = Integer.parseInt(st.nextToken());
		int sr = Integer.parseInt(st.nextToken());
		int sc = Integer.parseInt(st.nextToken());
		fr = Integer.parseInt(st.nextToken());
		fc = Integer.parseInt(st.nextToken());

		isVisited = new boolean[n][m];

		bfs(sr - 1, sc - 1);

		if (result == Integer.MAX_VALUE) {
			System.out.println(-1);
			return;
		}

		System.out.println(result);
	}

	private static void bfs(int startY, int startX) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {startY, startX, 0});
		isVisited[startY][startX] = true;

		while (!queue.isEmpty()) {
			int[] current = queue.poll();
			int y = current[0], x = current[1], count = current[2];

			if (y == fr - 1 && x == fc - 1) {
				result = count;
				return;
			}

			for (int i = 0; i < 4; i++) {
				int ny = y + dir[i][0];
				int nx = x + dir[i][1];

				if (ny < 0 || ny + h > n || nx < 0 || nx + w > m || isVisited[ny][nx])
					continue;

				if (checkWall(ny, nx)) {
					isVisited[ny][nx] = true;
					queue.offer(new int[] {ny, nx, count + 1});
				}
			}
		}
	}

	private static boolean checkWall(int y, int x) {
		for (int i = y; i < y + h; i++) {
			for (int j = x; j < x + w; j++) {
				if (map[i][j] == 1)
					return false;
			}
		}
		return true;
	}
}
