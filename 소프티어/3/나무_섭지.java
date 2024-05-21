import java.io.*;
import java.util.*;

public class 나무_섭지 {

	private static int[][] map;
	private static ArrayList<Ghost> ghosts = new ArrayList<>();
	private static int n, m;
	private static int[] dx = {0, 0, 1, -1};
	private static int[] dy = {1, -1, 0, 0};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		Namwoo namwoo = null;
		int[] ex = new int[2];
		map = new int[n][m];
		for (int i = 0; i < n; i++) {
			String input = br.readLine();
			for (int j = 0; j < m; j++) {
				char inp = input.charAt(j);
				if (inp == 'G') {
					ghosts.add(new Ghost(i, j, 0));
				} else if (inp == 'N') {
					namwoo = new Namwoo(i, j, 0);
				} else if (inp == 'D') {
					ex[0] = i;
					ex[1] = j;
				}
				map[i][j] = inp;
			}
		}
		int namwooDistance = namwooBfs(namwoo, ex);
		if (namwooDistance == Integer.MAX_VALUE) {
			System.out.println("No");
			return;
		}
		int idx = -1, value = Integer.MAX_VALUE;
		for (int i = 0; i < ghosts.size(); i++) {
			Ghost g = ghosts.get(i);

			int v = Math.abs(g.y - namwoo.y) + Math.abs(g.x - namwoo.x);

			if (v < value) {
				idx = i;
				value = v;
			}

		}

		boolean isFlag = false;
		if (!ghostBfs(ghosts.get(idx), ex, namwooDistance)) {
			System.out.println("No");
			return;
		}
		System.out.println("Yes");
	}

	static boolean ghostBfs(Ghost ghost, int[] ex, int minValue) {
		Queue<Ghost> queue = new LinkedList<>();
		queue.add(ghost);

		boolean[][] visited = new boolean[n][m];

		while (!queue.isEmpty()) {
			Ghost cGhost = queue.poll();

			if (cGhost.cnt > minValue) {
				return true;
			}

			if (cGhost.y == ex[0] && cGhost.x == ex[1] && cGhost.cnt < minValue) {
				return false;
			}

			for (int i = 0; i < 4; i++) {
				int ny = cGhost.y + dy[i];
				int nx = cGhost.x + dx[i];

				if (!isOnBoard(ny, nx)) {
					continue;
				}
				if (visited[ny][nx]) {
					continue;
				}
				visited[ny][nx] = true;

				queue.add(new Ghost(ny, nx, cGhost.cnt + 1));
			}
		}
		return true;
	}

	static int namwooBfs(Namwoo namwoo, int[] ex) {
		Queue<Namwoo> queue = new LinkedList<>();
		queue.add(namwoo);

		boolean[][] visited = new boolean[n][m];

		int result = Integer.MAX_VALUE;
		while (!queue.isEmpty()) {
			Namwoo cNamwoo = queue.poll();

			if (cNamwoo.y == ex[0] && cNamwoo.x == ex[1]) {
				result = Math.min(result, cNamwoo.cnt);
				return result;
			}

			for (int i = 0; i < 4; i++) {
				int ny = cNamwoo.y + dy[i];
				int nx = cNamwoo.x + dx[i];

				if (!isOnBoard(ny, nx)) {
					continue;
				}
				if (map[ny][nx] == '#' || visited[ny][nx]) {
					continue;
				}
				visited[ny][nx] = true;

				queue.add(new Namwoo(ny, nx, cNamwoo.cnt + 1));
			}
		}
		return result;
	}

	static boolean isOnBoard(int y, int x) {
		return y >= 0 && y < n && x >= 0 && x < m;
	}

	static class Ghost {
		int y;
		int x;
		int cnt;

		public Ghost(int y, int x, int cnt) {
			this.y = y;
			this.x = x;
			this.cnt = cnt;
		}
	}

	static class Namwoo {
		int y;
		int x;
		int cnt;

		public Namwoo(int y, int x, int cnt) {
			this.y = y;
			this.x = x;
			this.cnt = cnt;
		}
	}
}