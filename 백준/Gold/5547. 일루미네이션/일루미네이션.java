import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static int[][] oddDir = {{0, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}}; //홀수 행
	private static int[][] evenDir = {{0, -1}, {-1, -1}, {-1, 0}, {0, 1}, {1, 0}, {1, -1}}; //짝수 행
	private static int[][] map;
	private static int[][] resultMap;
	private static boolean[][] isVisited;
	private static int w, h;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		w = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());

		map = new int[h + 2][w + 2];
		resultMap = new int[h + 2][w + 2];
		isVisited = new boolean[h + 2][w + 2];

		for (int i = 1; i < h + 1; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j < w + 1; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		bfs();
		System.out.println(countResult());

	}

	private static void bfs() {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {0, 0});
		isVisited[0][0] = true;

		while (!queue.isEmpty()) {
			int[] current = queue.poll();

			int cy = current[0];
			int cx = current[1];

			int[][] curDir = oddDir;
			if (cy % 2 == 0) {
				curDir = evenDir;
			}

			for (int i = 0; i < 6; i++) {
				int ny = cy + curDir[i][0];
				int nx = cx + curDir[i][1];

				if (!isOnBoard(ny, nx)) {
					continue;
				}

				if (map[ny][nx] == 1) {
					resultMap[cy][cx]++;
					continue;
				}

				if (!isVisited[ny][nx]) {
					queue.add(new int[] {ny, nx});
					isVisited[ny][nx] = true;
				}
			}

		}
	}

	private static boolean isOnBoard(int y, int x) {
		return y >= 0 && y < h + 2 && x >= 0 && x < w + 2;
	}

	private static int countResult() {
		int result = 0;

		for (int i = 0; i < h + 2; i++) {
			for (int j = 0; j < w + 2; j++) {
				result += resultMap[i][j];
			}
		}
		return result;
	}
}