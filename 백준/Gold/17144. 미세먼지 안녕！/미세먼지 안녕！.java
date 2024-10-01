import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	private static class Dust {
		int y;
		int x;
		int value;

		public Dust(final int y, final int x, final int value) {
			this.y = y;
			this.x = x;
			this.value = value;
		}

		public int getDivideDust() {
			return value / 5;
		}

		public void setDustAfterSpread(int count) {
			this.value = (this.value / 5) * count;
		}

		public boolean equals(Dust dust) {
			return this.x == dust.x && this.y == dust.y;
		}
	}

	private static int[][] map;
	private static ArrayList<Dust> dusts = new ArrayList<>();
	private static int purifier;
	private static int r, c;
	private static int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		r = Integer.parseInt(st.nextToken()); // 세로
		c = Integer.parseInt(st.nextToken()); // 가로
		int t = Integer.parseInt(st.nextToken()); // 몇 번 실행되는지 시간

		map = new int[r][c];

		for (int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < c; j++) {
				int value = Integer.parseInt(st.nextToken());
				if (value == -1) {
					purifier = i;
				}
				map[i][j] = value;
			}
		}

		while (t-- > 0) {
			checkDusts();
			spreadMicroDust();
			operate();
		}

		System.out.println(countDustsValue() + 2);
	}

	private static int countDustsValue() {
		int result = 0;
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				result += map[i][j];
			}
		}
		return result;
	}

	private static void checkDusts() {
		dusts.clear();

		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (map[i][j] > 0) {
					dusts.add(new Dust(i, j, map[i][j]));
				}
			}
		}
	}

	private static void spreadMicroDust() {
		for (Dust dust : dusts) {
			int count = 0;
			for (int i = 0; i < 4; i++) {
				int ny = dust.y + dir[i][0];
				int nx = dust.x + dir[i][1];

				if (!isOnboard(ny, nx) || map[ny][nx] == -1) {
					continue;
				}
				count++;
				map[ny][nx] += dust.getDivideDust();
			}

			map[dust.y][dust.x] -= dust.getDivideDust() * count;
		}
	}

	private static void operate() {

		int top = purifier - 1;
		int down = purifier;

		// 위쪽 공기청정기의 바람은 반시계방향 순환,
		// 아래로 당기기
		for (int i = top - 1; i > 0; i--)
			map[i][0] = map[i - 1][0];
		// 왼쪽으로 당기기
		for (int i = 0; i < c - 1; i++)
			map[0][i] = map[0][i + 1];
		// 위로 당기기
		for (int i = 0; i < top; i++)
			map[i][c - 1] = map[i + 1][c - 1];
		// 오른쪽으로 당기기
		for (int i = c - 1; i > 1; i--)
			map[top][i] = map[top][i - 1];
		// 공기청정기에서 부는 바람은 미세먼지가 없는 바람
		map[top][1] = 0;

		// 아래쪽 공기청정기의 바람은 시계방향으로 순환
		// 위로 당기기
		for (int i = down + 1; i < r - 1; i++)
			map[i][0] = map[i + 1][0];
		// 왼쪽으로 당기기
		for (int i = 0; i < c - 1; i++)
			map[r - 1][i] = map[r - 1][i + 1];
		// 아래로 당기기
		for (int i = r - 1; i > down; i--)
			map[i][c - 1] = map[i - 1][c - 1];
		// 오른쪽으로 당기기
		for (int i = c - 1; i > 1; i--)
			map[down][i] = map[down][i - 1];
		// 공기청정기에서 부는 바람은 미세먼지가 없는 바람
		map[down][1] = 0;
	}

	private static boolean isOnboard(int y, int x) {
		return y >= 0 && y < r && x >= 0 && x < c;
	}
}