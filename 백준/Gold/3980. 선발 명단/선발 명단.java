import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static class Player {
		int position;
		int stats;

		public Player(final int position, final int stats) {
			this.position = position;
			this.stats = stats;
		}
	}

	private static ArrayList<ArrayList<Player>> players;
	private static int maxValue;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int testCase = Integer.parseInt(st.nextToken());

		while (testCase-- > 0) {
			maxValue = 0;
			players = new ArrayList<>();
			for (int i = 0; i < 11; i++) {
				ArrayList<Player> array = new ArrayList<>();

				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 11; j++) {
					int stat = Integer.parseInt(st.nextToken());

					if (stat == 0) {
						continue;
					}
					array.add(new Player(j + 1, stat));
				}
				players.add(array);
			}
			boolean[] isPlayer = new boolean[12];
			backTracking(isPlayer, 0, 0);
			sb.append(maxValue).append("\n");
		}
		System.out.println(sb);
	}

	private static void backTracking(boolean[] isPlayer, int totalStats, int depth) {
		if (depth == 11) {
			maxValue = Math.max(maxValue, totalStats);
			return;
		}
		ArrayList<Player> current = players.get(depth);
		for (Player player : current) {
			if (isPlayer[player.position]) {
				continue;
			}

			isPlayer[player.position] = true;
			backTracking(isPlayer, totalStats + player.stats, depth + 1);
			isPlayer[player.position] = false;
		}
	}
}