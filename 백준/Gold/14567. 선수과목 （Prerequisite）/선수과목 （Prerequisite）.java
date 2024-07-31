import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();
	private static int[] lectures;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		for (int i = 0; i < n + 1; i++) {
			arrayLists.add(new ArrayList<>());
		}

		lectures = new int[n + 1];
		int[] cnts = new int[n + 1];

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());

			int first = Integer.parseInt(st.nextToken());
			int second = Integer.parseInt(st.nextToken());

			arrayLists.get(first).add(second);
			cnts[second]++;
		}

		sorting(n, cnts);
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < n + 1; i++) {
			sb.append(lectures[i]).append(" ");
		}
		System.out.println(sb);
	}

	private static void sorting(int n, int[] cnts) {
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 1; i < n + 1; i++) {
			if (cnts[i] == 0) {
				queue.offer(i);
				lectures[i] = 1;
			}
		}

		while (!queue.isEmpty()) {
			int cur = queue.poll();

			for (int nextInt : arrayLists.get(cur)) {
				cnts[nextInt]--;
				lectures[nextInt] = Math.max(lectures[nextInt], lectures[cur] + 1);

				if (cnts[nextInt] == 0) {
					queue.add(nextInt);
				}
			}
		}
	}
}