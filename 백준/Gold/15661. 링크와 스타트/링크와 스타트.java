import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int[][] map;
	private static boolean[] visited;
	private static int n, result = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		map = new int[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		visited = new boolean[n];
		dfs(0);
		System.out.println(result);
	}

	private static void dfs(int cnt) {
		if (cnt == n) {
			int startTeam = 0;
			int linkTeam = 0;
			// 방문 x => start팀, 방문 o => link팀
			for (int i = 0; i < n; i++) {
				for (int j = i + 1; j < n; j++) {
					if (visited[i] != visited[j]) {
						continue;
					}

					if (visited[i]) {
						linkTeam += (map[i][j] + map[j][i]);
					} else {
						startTeam += (map[i][j] + map[j][i]);
					}
				}
			}
			result = Math.min(result, Math.abs(startTeam - linkTeam));
			return;
		}

		visited[cnt] = true;
		dfs(cnt + 1);

		visited[cnt] = false;
		dfs(cnt + 1);
	}
}