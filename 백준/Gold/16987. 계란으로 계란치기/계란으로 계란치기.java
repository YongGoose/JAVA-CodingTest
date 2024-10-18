import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Egg {
		int durability;
		int weight;

		public Egg(final int durability, final int weight) {
			this.durability = durability;
			this.weight = weight;
		}
	}

	private static Egg[] eggs;
	private static int result = Integer.MIN_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		eggs = new Egg[n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int durability = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			eggs[i] = new Egg(durability, weight);
		}

		dfs(0, 0);
		System.out.println(result);
	}

	private static void dfs(int cEgg, int count) {
		result = Math.max(result, count);

		if (cEgg == eggs.length) {
			return;
		}

		if (eggs[cEgg].durability <= 0) {
			dfs(cEgg + 1, count);
			return;
		}

		for (int i = 0; i < eggs.length; i++) {
			if (i == cEgg) {
				continue;
			}

			if (eggs[i].durability <= 0) {
				continue;
			}

			eggs[i].durability -= eggs[cEgg].weight;
			eggs[cEgg].durability -= eggs[i].weight;

			int brokenEgg = 0;
			for (Egg egg : eggs) {
				if (egg.durability <= 0) {
					brokenEgg++;
				}
			}

			dfs(cEgg + 1, brokenEgg);

			eggs[i].durability += eggs[cEgg].weight;
			eggs[cEgg].durability += eggs[i].weight;
		}
	}
}