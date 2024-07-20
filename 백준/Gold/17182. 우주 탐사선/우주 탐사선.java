import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int[][] planet;
	// static PriorityQueue<Node>[] planetQue;
	static int N;
	static int start;
	static int result = Integer.MAX_VALUE;
	static boolean[] isVisited;

	static class Node implements Comparable<Node> {
		int index;
		int value;

		public Node(final int index, final int value) {
			this.index = index;
			this.value = value;
		}

		@Override
		public int compareTo(final Node o) {
			return this.value - o.value;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(buffer.readLine());

		N = Integer.parseInt(token.nextToken());
		start = Integer.parseInt(token.nextToken());
		// planetQue = new PriorityQueue[N];
		// for (int i = 0; i < N; i++) {
		// 	planetQue[i] = new PriorityQueue<>();
		// }
		isVisited = new boolean[N];

		planet = new int[N][N];
		for (int i = 0; i < N; i++) {
			token = new StringTokenizer(buffer.readLine());
			for (int j = 0; j < N; j++) {
				planet[i][j] = Integer.parseInt(token.nextToken());
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					if (i == j) {
						continue;
					}
					planet[i][j] = Math.min(planet[i][j], planet[i][k] + planet[k][j]);
				}
			}
		}
		// for (int i = 0; i < N; i++) {
		// 	for (int j = 0; j < N; j++) {
		// 		planetQue[i].offer(new Node(j, planet[i][j]));
		// 	}
		// }

		isVisited[start] = true;
		backTracking(start, 0, 0);

		System.out.println(result);
	}

	static void backTracking(int curr, int value, int cnt) {

		if (cnt == N - 1) {
			result = Math.min(result, value);
		}

		// while (!planetQue[curr].isEmpty()) {
		// 	Node node = planetQue[curr].peek();
		//
		// 	if (isVisited[node.index]) {
		// 		continue;
		// 	}
		//
		// 	isVisited[node.index] = true;
		// 	backTracking(node.index, value + node.value, cnt + 1);
		// 	isVisited[node.index] = false;
		// }

		for (int i = 0; i < N; i++) {
			if (isVisited[i]) {
				continue;
			}

			isVisited[i] = true;
			backTracking(i, value + planet[curr][i], cnt + 1);
			isVisited[i] = false;
		}
	}
}
