import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int[] works = new int[n + 1];
		int[] indegree = new int[n + 1];
		
		for (int i = 0; i < n + 1; i++) {
			arrayLists.add(new ArrayList<>());
		}

		for (int i = 1; i < n + 1; i++) {
			st = new StringTokenizer(br.readLine());

			works[i] = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());

			for (int j = 0; j < k; j++) {
				int cur = Integer.parseInt(st.nextToken());
				arrayLists.get(cur).add(i);
				indegree[i]++;
			}
		}

		System.out.println(topologicalSort(n, works, indegree));
	}

	private static int topologicalSort(int n, int[] works, int[] indegree) {
		Queue<Integer> queue = new LinkedList<>();
		int[] results = new int[n + 1];

		for (int i = 1; i < n + 1; i++) {
			results[i] = works[i];

			if (indegree[i] == 0) {
				queue.add(i);
			}
		}

		while (!queue.isEmpty()) {
			int currentWork = queue.poll();

			for (int nextWork : arrayLists.get(currentWork)) {
				indegree[nextWork]--;

				results[nextWork] = Math.max(results[nextWork], results[currentWork] + works[nextWork]);

				if (indegree[nextWork] == 0) {
					queue.offer(nextWork);
				}
			}
		}
		int res = 0;
		for (int i = 1; i < n + 1; i++) {
			res = Math.max(res, results[i]);
		}
		return res;
	}
}