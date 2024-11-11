import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	private static final int RIGHT = 0;  // →
	private static final int DOWN = 1;   // ↓
	private static final int LEFT = 2;   // ←
	private static final int UP = 3;     // ↑

	private static final int[] dy = {0, 1, 0, -1};
	private static final int[] dx = {1, 0, -1, 0};

	private static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		map = new int[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		List<Integer> resultList = new ArrayList<>();
		// 왼쪽 면
		for (int i = 0; i < n; i++) {
			resultList.add(traceLight(n, m, i, -1, RIGHT));
		}
		// 아래쪽 면
		for (int i = 0; i < m; i++) {
			resultList.add(traceLight(n, m, n, i, UP));
		}
		// 오른쪽 면
		for (int i = n - 1; i >= 0; i--) {
			resultList.add(traceLight(n, m, i, m, LEFT));
		}
		// 위쪽 면
		for (int i = m - 1; i >= 0; i--) {
			resultList.add(traceLight(n, m, -1, i, DOWN));
		}
		for (int res : resultList) {
			System.out.println(res);
		}
	}

	private static int traceLight(int n, int m, int startY, int startX, int dir) {
		int y = startY;
		int x = startX;

		while (true) {
			y += dy[dir];
			x += dx[dir];

			if (!isOnBoard(y, x, n, m)) {
				return traceExitNum(y, x, n, m);
			}

			if (map[y][x] == 1) {
				dir = mirrorReflection(dir);
			}
		}
	}

	private static int traceExitNum(int y, int x, int n, int m) {
		//위
		if (y == -1) {
			return (m - x) + n * 2 + m;
		}

		//아래
		if (y == n) {
			return x + n + 1;
		}

		// 왼
		if (x == -1) {
			return y + 1;
		}

		//오
		if (x == m) {
			return n + m + (n - y);
		}
		// not reached
		return 0;
	}

	private static int mirrorReflection(int dir) {
		switch (dir) {
			case RIGHT:
				return UP;
			case UP:
				return RIGHT;
			case LEFT:
				return DOWN;
			case DOWN:
				return LEFT;
			default:
				return 0;
		}
	}

	private static boolean isOnBoard(int y, int x, int n, int m) {
		return y >= 0 && y < n && x >= 0 && x < m;
	}
}