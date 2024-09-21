import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static class FireBall {
		int y, x, dir, mess, speed;

		public FireBall(int y, int x, int dir, int mess, int speed) {
			this.y = y;
			this.x = x;
			this.dir = dir;
			this.mess = mess;
			this.speed = speed;
		}
	}

	static ArrayList<FireBall>[][] map;
	static ArrayList<FireBall> fireBalls = new ArrayList<>();
	static int n;
	static int[][] dir = {
		{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}
	};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		map = new ArrayList[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = new ArrayList<>();
			}
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken()) - 1;
			int x = Integer.parseInt(st.nextToken()) - 1;
			int mess = Integer.parseInt(st.nextToken());
			int speed = Integer.parseInt(st.nextToken());
			int dir = Integer.parseInt(st.nextToken());

			FireBall fireBall = new FireBall(y, x, dir, mess, speed);
			fireBalls.add(fireBall);
		}

		while (k-- > 0) {
			order();
			searchMultiFireBall();
		}

		System.out.println(sumTotalFireBall());
	}

	private static void order() {
		for (FireBall fireBall : fireBalls) {
			map[fireBall.y][fireBall.x].remove(fireBall);

			int d = fireBall.dir;
			int newX = (fireBall.x + (dir[d][1] * fireBall.speed)) % n;
			if (newX < 0) {
				newX += n;
			}
			int newY = (fireBall.y + (dir[d][0] * fireBall.speed)) % n;
			if (newY < 0) {
				newY += n;
			}

			fireBall.x = newX;
			fireBall.y = newY;

			map[newY][newX].add(fireBall);
		}
	}

	private static void searchMultiFireBall() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j].size() > 1) {
					merge(i, j);
				}
			}
		}
	}

	private static void merge(int y, int x) {
		ArrayList<FireBall> targetFireBalls = map[y][x];
		int totalMess = 0;
		int totalSpeed = 0;
		Boolean beforeIsEvenNumber = null;
		boolean isEvenNumber;
		boolean isSame = true;

		ArrayList<FireBall> removeFireBall = new ArrayList<>();
		for (FireBall targetFireBall : targetFireBalls) {
			removeFireBall.add(targetFireBall);
			totalMess += targetFireBall.mess;
			totalSpeed += targetFireBall.speed;
			isEvenNumber = targetFireBall.dir % 2 == 0;

			if (beforeIsEvenNumber == null) {
				beforeIsEvenNumber = isEvenNumber;
				continue;
			}

			if (beforeIsEvenNumber != isEvenNumber) {
				isSame = false;
			}
		}
		int newSpeed = totalSpeed / targetFireBalls.size();
		int newMess = totalMess / 5;

		fireBalls.removeAll(removeFireBall);
		map[y][x].clear();
		if (newMess == 0) {
			return;
		}

		int cDir = isSame ? 0 : 1;
		for (int i = 0; i < 4; i++) {
			FireBall newFireBall = new FireBall(y, x, cDir, newMess, newSpeed);
			fireBalls.add(newFireBall);
			map[y][x].add(newFireBall);
			cDir += 2;
		}
	}

	private static int sumTotalFireBall() {
		int result = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j].isEmpty()) {
					continue;
				}
				ArrayList<FireBall> removeFireBalls = new ArrayList<>();

				for (FireBall f : map[i][j]) {
					result += f.mess;
					removeFireBalls.add(f);
				}
				map[i][j].removeAll(removeFireBalls);
			}
		}
		return result;
	}
}