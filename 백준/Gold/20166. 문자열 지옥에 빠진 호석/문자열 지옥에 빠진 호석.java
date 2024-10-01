import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	private static Character[][] map;
	private static Set<String> likeString = new HashSet<>();
	private static int n, m, maxLength;
	private static Map<String, Integer> resultMap = new HashMap<>();
	private static int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		map = new Character[n][m];
		for (int i = 0; i < n; i++) {
			String string = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = string.charAt(j);
			}
		}

		for (int i = 0; i < k; i++) {
			String s = br.readLine();
			resultMap.put(s, 0);
			maxLength = Math.max(maxLength, s.length());
			likeString.add(s);
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				dfs(i, j, 1, map[i][j].toString());
			}
		}
		resultMap.forEach((key, value) -> System.out.println(value));
	}

	private static void dfs(int y, int x, int depth, String answer) {
		if (likeString.contains(answer)) {
			resultMap.put(answer, resultMap.get(answer) + 1);
		}

		if (depth == maxLength) {
			return;
		}

		for (int i = 0; i < 8; i++) {
			int ny = ((y + dir[i][0]) % n + n) % n;
			int nx = ((x + dir[i][1]) % m + m) % m;


			dfs(ny, nx, depth + 1,  answer + map[ny][nx]);
		}
	}

}