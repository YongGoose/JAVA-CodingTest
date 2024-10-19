import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static class Cloud {
		int y, x;

		public Cloud(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

	static class Basket {
		boolean wasCloud;
		int water;

		public Basket(int water) {
			this.wasCloud = false;
			this.water = water;
		}
	}

	private static Basket[][] baskets;
	private static List<Cloud> clouds = new ArrayList<>();
	private static int n;
	private static int[][] dir = {{}, {0, -1}, {-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0},
		{1, -1}};
	private static int[][] copyDir = {{-1, -1}, {-1, 1}, {1, -1}, {1, 1}};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		baskets = new Basket[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				baskets[i][j] = new Basket(Integer.parseInt(st.nextToken()));
			}
		}

		initCloud();
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int direction = Integer.parseInt(st.nextToken());
			int distance = Integer.parseInt(st.nextToken());
			moveAndRain(direction, distance);
			copyWater();
			generateCloud();
		}

		System.out.println(sumWater());
	}

	private static int sumWater() {
		int result = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				result += baskets[i][j].water;
			}
		}
		return result;
	}

	private static void moveAndRain(int direction, int distance) {
		for (Cloud cloud : clouds) {
			int ny = calculateDistance(cloud.y, dir[direction][0] * distance);
			int nx = calculateDistance(cloud.x, dir[direction][1] * distance);

			cloud.y = ny;
			cloud.x = nx;
			baskets[ny][nx].water++;
			baskets[ny][nx].wasCloud = true;
		}
	}

	private static void copyWater() {
		for (Cloud cloud : clouds) {
			for (int i = 0; i < 4; i++) {
				int ny = cloud.y + copyDir[i][0];
				int nx = cloud.x + copyDir[i][1];
				if (isOnBoard(ny, nx) && baskets[ny][nx].water > 0) {
					baskets[cloud.y][cloud.x].water ++;
				}
			}
		}
		clouds.clear();
	}

	private static void generateCloud() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (!baskets[i][j].wasCloud && baskets[i][j].water >= 2) {
					clouds.add(new Cloud(i, j));
					baskets[i][j].water -= 2;
				}
				baskets[i][j].wasCloud = false;
			}
		}
	}

	private static void initCloud() {
		clouds.add(new Cloud(n - 1, 0));
		clouds.add(new Cloud(n - 1, 1));
		clouds.add(new Cloud(n - 2, 0));
		clouds.add(new Cloud(n - 2, 1));
	}

	private static int calculateDistance(int current, int dis) {
		return ((current + dis) % n + n) % n;
	}

	private static boolean isOnBoard(int y, int x) {
		return y >= 0 && y < n && x >= 0 && x < n;
	}
}