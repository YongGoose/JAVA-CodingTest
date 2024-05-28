import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int[][] map;

	static int[][] dMove = new int[][] {{0, -1}, {0, 1}, {-1, 0}};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < 10; i++) {
			st = new StringTokenizer(br.readLine());
			int testNum = Integer.parseInt(st.nextToken());

			map = new int[100][100];
			int[] landing = new int[2];
			for (int j = 0; j < 100; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 0; k < 100; k++) {
					int num = Integer.parseInt(st.nextToken());
					if (num == 2) {
						landing[0] = j;
						landing[1] = k;
					}
					map[j][k] = num;
				}
			}
			sb.append("#").append(testNum).append(" ").append(bfs(landing)).append("\n");
		}
		System.out.println(sb);
	}

	static int bfs(int[] landing) {
		int y = landing[0];
		int x = landing[1];

		while (y != 0) {
			for (int i = 0; i < 3; i++) {
				int ny = dMove[i][0] + y;
				int nx = dMove[i][1] + x;

				if (!isOnBoard(ny, nx)) {
					continue;
				}
				if (map[ny][nx] == 1) {
					map[ny][nx] = -1;
					y = ny;
					x = nx;
					break;
				}
			}
		}
		return x;
	}

	static boolean isOnBoard(int y, int x) {
		return y >= 0 && y < 100 && x >= 0 && x < 100;
	}
}