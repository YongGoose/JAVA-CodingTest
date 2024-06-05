import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static int[][] map;
	static boolean[][] visited;
	static int[] dy = {0, 0, -1, 1};
	static int[] dx = {-1, 1, 0, 0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < 10; i++) {
			st = new StringTokenizer(br.readLine());
			int testNum = Integer.parseInt(st.nextToken());

			int[][] point = new int[2][2];
			map = new int[16][16];
			visited = new boolean[16][16];
			for (int j = 0; j < 16; j++) {
				String input = br.readLine();
				for (int k = 0; k < 16; k++) {
					int num = input.charAt(k) - '0';

					if (num == 2) {
						point[0][0] = j;
						point[0][1] = k;
					} else if (num == 3) {
						point[1][0] = j;
						point[1][1] = k;
					}

					map[j][k] = num;
				}
			}
			sb.append("#").append(testNum).append(" ").append(dfs(point)).append("\n");
		}
		System.out.println(sb);
	}

	static int dfs(int[][] point) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(point[0]);

		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			if (cur[0] == point[1][0] && cur[1] == point[1][1]) {
				return 1;
			}

			for (int i = 0; i < 4; i++) {
				int ny = cur[0] + dy[i];
				int nx = cur[1] + dx[i];

				if (!isOnBoard(ny, nx)) {
					continue;
				}
				if (visited[ny][nx]) {
					continue;
				}

				visited[ny][nx] = true;
				if (map[ny][nx] != 1) {
					queue.add(new int[] {ny, nx});
				}
			}
		}
		return 0;
	}

	static boolean isOnBoard(int y, int x) {
		return y >= 0 && y < 16 && x >= 0 && x < 16;
	}
}