import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int n, m, result;
	private static boolean[][] nemos;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		nemos = new boolean[n][m];
		backTracking(0);
		System.out.println(result);
	}

	private static void backTracking(int depth) {
		if (depth == n * m) {
			result++;
			return;
		}

		int y = depth / m;
		int x = depth % m;

		backTracking(depth + 1);

		if (!makeSquare(y, x)) {
			nemos[y][x] = true;
			backTracking(depth + 1);
			nemos[y][x] = false;
		}
	}

	private static boolean makeSquare(int y, int x) {
		if (y > 0 && x > 0) {
			return nemos[y-1][x] && nemos[y][x-1] && nemos[y-1][x-1];
		}
		return false;
	}
}