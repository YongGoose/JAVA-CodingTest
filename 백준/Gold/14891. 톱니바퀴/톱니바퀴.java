import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	private static int[][] gears = new int[4][8];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		for (int i = 0; i < 4; i++) {
			String input = br.readLine();

			for (int j = 0; j < 8; j++) {
				gears[i][j] = input.charAt(j) - '0';
			}
		}

		int testCase = Integer.parseInt(br.readLine());

		for (int i = 0; i < testCase; i++) {
			st = new StringTokenizer(br.readLine());

			int number = Integer.parseInt(st.nextToken()) - 1;
			int direction = Integer.parseInt(st.nextToken());

			rightSide(number + 1, -direction);
			leftSide(number - 1, -direction);
			scrollGear(number, direction);
		}

		int result = 0;
		if (gears[0][0] == 1) {
			result += 1;
		}
		if (gears[1][0] == 1) {
			result += 2;
		}
		if (gears[2][0] == 1) {
			result += 4;
		}
		if (gears[3][0] == 1) {
			result += 8;
		}

		System.out.println(result);
	}

	private static void scrollGear(int number, int direction) {
		if (direction == 1) {
			int popNum = gears[number][7];

			for (int i = 7; i > 0; i--) {
				gears[number][i] = gears[number][i - 1];
			}
			gears[number][0] = popNum;
			return;
		}
		int popNum = gears[number][0];

		for (int i = 0; i < 7; i++) {
			gears[number][i] = gears[number][i + 1];
		}
		gears[number][7] = popNum;
	}


	private static void rightSide(int number, int direction) {
		if (number > 3) {
			return;
		}

		if (gears[number - 1][2] == gears[number][6]) {
			return;
		}

		rightSide(number + 1, -direction);
		scrollGear(number, direction);
	}

	private static void leftSide(int number, int direction) {
		if (number < 0) {
			return;
		}

		if (gears[number + 1][6] == gears[number][2]) {
			return;
		}

		leftSide(number - 1, -direction);
		scrollGear(number, direction);
	}
}