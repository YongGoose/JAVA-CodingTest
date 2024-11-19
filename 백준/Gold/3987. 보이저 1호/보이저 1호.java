import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static final int U = 0;
	private static final int R = 1;
	private static final int D = 2;
	private static final int L = 3;

	private static char[][] map;
	private static int resultDir, length = Integer.MIN_VALUE;
	private static boolean isEternal;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		map = new char[n][m];
		for (int i = 0; i < n; i++) {
			map[i] = br.readLine().toCharArray();
		}

		st = new StringTokenizer(br.readLine());

		int pr = Integer.parseInt(st.nextToken()) - 1;
		int pc = Integer.parseInt(st.nextToken()) - 1;

		for (int i = 0; i < 4; i++) {
			signal(pr, pc, i);
		}

		StringBuilder sb = new StringBuilder();

		if (resultDir == 0) {
			sb.append("U");
		} else if (resultDir == 1) {
			sb.append("R");
		} else if(resultDir == 2) {
			sb.append("D");
		} else {
			sb.append("L");
		}

		if (isEternal) {
			sb.append("\n").append("Voyager");
			System.out.println(sb);
			return;
		}

		sb.append("\n").append(length);
		System.out.println(sb);
	}

	private static void signal(int pc, int pr, int dir) {
		if (isEternal) {
			return;
		}

		int y = pc;
		int x = pr;
		int currentDir = dir;
		int currentLength = 1;
		while (true) {
			if (currentDir == U) {
				y --;
			} else if (currentDir == D) {
				y++;
			} else if (currentDir == R) {
				x++;
			} else {
				x--;
			}

			if (!isOnboard(y, x)) {
				break;
			}

			if (map[y][x] == 'C') {
				break;
			}

			if (y == pc && x == pr && currentDir == dir) {
				resultDir = dir;
				isEternal = true;
				return;
			}

			if (map[y][x] != '.') {
				currentDir = turn(currentDir, map[y][x]);
			}

			currentLength++;
		}

		if (currentLength > length) {
			length = currentLength;
			resultDir = dir;
		}
	}

	private static boolean isOnboard(int y, int x) {
		return y >= 0 && y < map.length && x >= 0 && x < map[0].length;
	}

	private static int turn(int dir, char mirror) {
		if (mirror == '/') {
			switch (dir) {
				case U:
					return R;
				case R:
					return U;
				case D:
					return L;
				case L:
					return D;
			}
		}

		switch (dir) {
			case U:
				return L;
			case L:
				return U;
			case D:
				return R;
			case R:
				return D;
			default:
				return -1;
		}
	}
}