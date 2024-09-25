import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	private static class Pair implements Comparable<Pair> {

		int number;
		int count;

		public Pair(final int number, final int count) {
			this.number = number;
			this.count = count;
		}

		@Override
		public int compareTo(final Pair o) {
			if (this.count == o.count) {
				return this.number - o.number;
			}
			return this.count - o.count;
		}
	}

	private static int[][] map = new int[101][101];
	private static int yLength = 3;
	private static int xLength = 3;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		for (int i = 1; i < 4; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 1; j < 4; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}


		for (int num = 0; num < 101; num++) {
			if (map[r][c] == k) {
				System.out.println(num);
				return;
			}

			if (xLength >= yLength) {
				for (int i = 1; i <= xLength; i++) {
					R(i);
				}
			} else {
				for (int i = 1; i <= yLength; i++) {
					C(i);
				}
			}
		}
		System.out.println(-1);
	}

	// 행을 정렬할 때
	static void R(int key) {
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		Map<Integer, Integer> hashMap = new HashMap<>();

		for (int i = 1; i <= yLength; i++) {
			if (map[key][i] == 0)
				continue;
			hashMap.compute(map[key][i], (num, count) -> count == null ? 1 : count + 1);
		}

		hashMap.forEach((k, v) -> pq.add(new Pair(k, v)));

		int i = 1;
		while (!pq.isEmpty()) {
			Pair p = pq.poll();
			map[key][i++] = p.number;
			map[key][i++] = p.count;
		}

		yLength = Math.max(yLength, i);

		while (i <= 99) {
			map[key][i++] = 0;
			map[key][i++] = 0;
		}
	}

	static void C(int key) {
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		Map<Integer, Integer> hashmap = new HashMap<>();

		for (int i = 1; i <= xLength; i++) {
			if (map[i][key] == 0)
				continue;
			hashmap.compute(map[i][key], (num, count) -> count == null ? 1 : count + 1);
		}

		hashmap.forEach((k, v) -> pq.add(new Pair(k, v)));

		int i = 1;
		while (!pq.isEmpty()) {
			Pair p = pq.poll();
			map[i++][key] = p.number;
			map[i++][key] = p.count;
		}

		xLength = Math.max(xLength, i);

		while (i <= 99) {
			map[i++][key] = 0;
			map[i++][key] = 0;
		}
	}
}
