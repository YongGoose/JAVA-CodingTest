import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	private static int[][] dMoves = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
	private static char[][] board;
	private static int r, c, result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		board = new char[r][c];
		for (int i = 0; i < r; i++) {
			board[i] = br.readLine().toCharArray();
		}
		Set<Character> set = new HashSet<>();
		set.add(board[0][0]);
		backTracking(1, set, new int[] {0,0});

		System.out.println(result);
	}

	private static void backTracking(int depth, Set<Character> set, int[] player) {
		boolean isFlag = false;
		for (int i = 0; i < 4; i++) {
			int ny = player[0] + dMoves[i][0];
			int nx = player[1] + dMoves[i][1];

			if (!isOnBoard(ny, nx)) {
				continue;
			}

			char currentCharacter = board[ny][nx];

			if (set.contains(currentCharacter)) {
				continue;
			}
			set.add(currentCharacter);
			isFlag = true;

			backTracking(depth + 1, set, new int[] {ny, nx});

			set.remove(currentCharacter);
		}

		if (!isFlag) {
			result = Math.max(result, depth);
			return;
		}
	}

	private static boolean isOnBoard(int y, int x) {
		return y >= 0 && y < r && x >= 0 && x < c;
	}
}