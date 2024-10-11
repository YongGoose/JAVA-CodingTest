import java.io.*;
import java.util.*;

public class Main {
	static int N, K;
	static int[] belt;
	static boolean[] robot;
	static int zeroDurability = 0;
	static int step = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		belt = new int[2 * N];
		robot = new boolean[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 2 * N; i++) {
			belt[i] = Integer.parseInt(st.nextToken());
		}

		while (zeroDurability < K) {
			step++;
			rotate();
			moveRobots();
			loadRobot();
		}

		System.out.println(step);
	}

	static void rotate() {
		int last = belt[2 * N - 1];
		for (int i = 2 * N - 1; i > 0; i--) {
			belt[i] = belt[i - 1];
		}
		belt[0] = last;

		for (int i = N - 1; i > 0; i--) {
			robot[i] = robot[i - 1];
		}
		robot[0] = false;
		robot[N - 1] = false;  // 내리는 위치의 로봇 제거
	}

	static void moveRobots() {
		for (int i = N - 2; i >= 0; i--) {
			if (robot[i] && !robot[i + 1] && belt[i + 1] > 0) {
				robot[i] = false;
				robot[i + 1] = true;
				belt[i + 1]--;
				if (belt[i + 1] == 0)
					zeroDurability++;
			}
		}
		robot[N - 1] = false;  // 내리는 위치의 로봇 제거
	}

	static void loadRobot() {
		if (!robot[0] && belt[0] > 0) {
			robot[0] = true;
			belt[0]--;
			if (belt[0] == 0)
				zeroDurability++;
		}
	}
}