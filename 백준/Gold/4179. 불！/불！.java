import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static boolean[][] visited;
	private static char[][] map;
	private static int[][] dMove = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
	private static int r, c;

	public static class Fire{
		int y;
		int x;

		public Fire(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		int[][] fireMap = new int[r][c];
		int[][] personMap = new int[r][c];

		map = new char[r][c];

		int[] peo = new int[2];
		ArrayList<Fire> fires = new ArrayList<>();

		for (int i = 0; i < r; i++) {
			map[i] = br.readLine().toCharArray();

			for (int j = 0; j < c; j++) {
				if (map[i][j] == 'J') {
					peo[0] = i;
					peo[1] = j;
				}

				if (map[i][j] == 'F') {
					fires.add(new Fire(i, j));
				}
			}
		}
		for (int i = 0; i < r; i++) {
			Arrays.fill(fireMap[i], Integer.MAX_VALUE);
		}
		visited = new boolean[r][c];
		fires.forEach(fire -> {
			visited[fire.y][fire.x] = true;
			fireMap[fire.y][fire.x] = 0;
		});
		bfs(fires, fireMap);

		visited = new boolean[r][c];
		visited[peo[0]][peo[1]] = true;
		int result = peopleBfs(peo, personMap, fireMap);

		if (result == Integer.MAX_VALUE) {
			System.out.println("IMPOSSIBLE");
			return;
		}
		System.out.println(result);
	}

	private static void bfs(ArrayList<Fire> fires, int[][] cMap) {
		Queue<int[]> queue = new LinkedList<>();
		fires.forEach(fire -> {
			queue.add(new int[] {fire.y, fire.x});
		});

		while (!queue.isEmpty()) {
			int[] cu = queue.poll();

			int y = cu[0];
			int x = cu[1];

			for (int i = 0; i < 4; i++) {
				int ny = dMove[i][0] + y;
				int nx = dMove[i][1] + x;

				if (!isOnBoard(ny, nx)) {
					continue;
				}
				if (visited[ny][nx] || map[ny][nx] == '#') {
					continue;
				}

				visited[ny][nx] = true;
				queue.add(new int[] {ny, nx});
				cMap[ny][nx] = cMap[y][x] + 1;
			}
		}
	}

	private static int peopleBfs(int[] current, int[][] cmap, int[][] fireMap) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(current);

		while (!queue.isEmpty()) {
			int[] cu = queue.poll();
			int y = cu[0];
			int x = cu[1];

			for (int i = 0; i < 4; i++) {
				int ny = dMove[i][0] + y;
				int nx = dMove[i][1] + x;

				int idx = cmap[y][x] + 1;
				if (!isOnBoard(ny, nx)) {
					return idx;
				}
				if (visited[ny][nx] || map[ny][nx] == '#') {
					continue;
				}
				if (fireMap[ny][nx] <= idx) {
					continue;
				}

				visited[ny][nx] = true;
				cmap[ny][nx] = idx;
				queue.add(new int[] {ny, nx});
			}
		}
		return Integer.MAX_VALUE;
	}

	private static boolean isOnBoard(int y, int x) {
		return y >= 0 && x >= 0 && y < r && x < c;
	}
}