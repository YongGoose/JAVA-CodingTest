import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	private static class Node implements Comparable<Node>{
		int to;
		int cost;

		public Node(int to, int cost) {
			this.to = to;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}
	}

	private static ArrayList<ArrayList<Node>> nodes = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());

		for (int i = 0; i < n + 1; i++) {
			nodes.add(new ArrayList<>());
		}
		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			nodes.get(a).add(new Node(b, c));
			nodes.get(b).add(new Node(a, c));
		}

		st = new StringTokenizer(br.readLine());
		int v1 = Integer.parseInt(st.nextToken());
		int v2 = Integer.parseInt(st.nextToken());

		int[] costs = new int[n + 1];
		boolean[] visited = new boolean[n + 1];

		// 1 -> v1
		Arrays.fill(costs, Integer.MAX_VALUE);
		costs[1] = 0;
		int oneToV1 = djistra(1, v1, costs, visited);

		// 1 -> v2
		Arrays.fill(costs, Integer.MAX_VALUE);
		visited = new boolean[n + 1];
		costs[1] = 0;
		int oneToV2 = djistra(1, v2, costs, visited);

		// v1 -> v2
		Arrays.fill(costs, Integer.MAX_VALUE);
		visited = new boolean[n + 1];
		costs[v1] = 0;
		int v1ToV2 = djistra(v1, v2, costs, visited);

		// v2 -> v1
		Arrays.fill(costs, Integer.MAX_VALUE);
		visited = new boolean[n + 1];
		costs[v2] = 0;
		int v2ToV1 = djistra(v2, v1, costs, visited);

		// v1 -> n
		Arrays.fill(costs, Integer.MAX_VALUE);
		visited = new boolean[n + 1];
		costs[v1] = 0;
		int v1ToN = djistra(v1, n, costs, visited);

		// v2 -> n
		Arrays.fill(costs, Integer.MAX_VALUE);
		visited = new boolean[n + 1];
		costs[v2] = 0;
		int v2ToN = djistra(v2, n, costs, visited);

		int result = Integer.MAX_VALUE;
		boolean flag = false;
		// 1 -> v1 -> v2 -> n
		if (oneToV1 != Integer.MAX_VALUE && v1ToV2 != Integer.MAX_VALUE && v2ToN != Integer.MAX_VALUE) {
			flag = true;
			result = Math.min(result, oneToV1 + v1ToV2 + v2ToN);
		}

		// 1 -> v2 -> v1 -> n
		if (oneToV2 != Integer.MAX_VALUE && v2ToV1 != Integer.MAX_VALUE && v1ToN != Integer.MAX_VALUE) {
			flag = true;
			result = Math.min(result, oneToV2 + v2ToV1 + v1ToN);
		}

		if (!flag) {
			System.out.println("-1");
			return;
		}
		System.out.println(result);
	}
	
	private static int djistra(int from, int to, int[] costs, boolean[] visited) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(from, 0));

		while (!pq.isEmpty()) {
			Node node = pq.poll();

			if (visited[node.to]) {
				continue;
			}
			visited[node.to] = true;

			for (Node n : nodes.get(node.to)) {
				if (!visited[n.to] && costs[n.to] > costs[node.to] + n.cost) {
					costs[n.to] = costs[node.to] + n.cost;
					pq.offer(new Node(n.to, costs[n.to]));
				}
			}
		}
		return costs[to];
	}
}
