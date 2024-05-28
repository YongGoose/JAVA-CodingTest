import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	static int result;
	static boolean[][] visited;
	static int[][] map;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int testCase = Integer.parseInt(st.nextToken());
		for (int i = 1; i < testCase + 1; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());

			map = new int[n][n];

			for (int j = 0; j < n; j++) {
				String input = br.readLine();
				for (int k = 0; k < n; k++) {
					map[j][k] = input.charAt(k) - '0';
				}
			}
			result = Integer.MAX_VALUE;
			visited = new boolean[n][n];

			bfs(0, 0, n);
			sb.append("#").append(i).append(" ").append(result).append("\n");
		}
		System.out.println(sb);
	}

	static void bfs(int y, int x, int n) {
		PriorityQueue<Point> queue = new PriorityQueue<>();
		queue.add(new Point(y, x, 0));

		while (!queue.isEmpty()) {
			Point point = queue.poll();

			if (point.x == n - 1 && point.y == n - 1) {
				result = point.value;
				break;
			}

			for (int i = 0; i < 4; i++) {
				int ny = point.y + dy[i];
				int nx = point.x + dx[i];

				if (!isOnBoard(ny, nx, n)) {
					continue;
				}
				if (visited[ny][nx]) {
					continue;
				}

				visited[ny][nx] = true;
				queue.add(new Point(ny, nx, point.value + map[ny][nx]));
			}
		}
	}

	static class Point implements Comparable<Point> {
		int y;
		int x;
		int value;

		public Point(int y, int x, int value) {
			this.y = y;
			this.x = x;
			this.value = value;
		}

		@Override
		public int compareTo(Point o) {
			return this.value - o.value;
		}
	}

	static boolean isOnBoard(int y, int x, int n) {
		return y >= 0 && y < n && x >= 0 && x < n;
	}
}