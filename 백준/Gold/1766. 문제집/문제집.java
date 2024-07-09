import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();
		for (int i = 0; i < n + 1; i++) {
			arrayLists.add(new ArrayList<>());
		}

		int[] questions = new int[n + 1];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			arrayLists.get(a).add(b);
			questions[b]++;
		}

		PriorityQueue<Integer> results = new PriorityQueue<>();
		for (int i = 1; i < n + 1; i++) {
			if (questions[i] == 0) {
				results.add(i);
			}
		}

		StringBuilder sb = new StringBuilder();
		while (!results.isEmpty()) {
			int currentQuestion = results.poll();
			sb.append(currentQuestion).append(" ");

			for (int nextInt : arrayLists.get(currentQuestion)) {
				questions[nextInt]--;

				if (questions[nextInt] == 0) {
					results.offer(nextInt);
				}
			}
		}
		System.out.println(sb);
	}
}