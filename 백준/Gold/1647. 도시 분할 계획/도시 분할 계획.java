import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class Node implements Comparable<Node> {
		int from;
		int to;
		int value;

		public Node(final int from, final int to, final int value) {
			this.from = from;
			this.to = to;
			this.value = value;
		}

		@Override
		public int compareTo(Node o) {
			return this.value - o.value;
		}
	}
	
	private static int[] parentHouse;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		PriorityQueue<Node> queue = new PriorityQueue<>();
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());

			queue.add(new Node(from, to, value));
		}

		parentHouse = new int[n + 1];
		for (int i = 0; i < n + 1; i++) {
			parentHouse[i] = i;
		}

		System.out.println(kruskal(queue));
	}

	private static int kruskal(PriorityQueue<Node> queue) {
		int removeNode = 0;
		int result = 0;

		while (!queue.isEmpty()) {
			Node node = queue.poll();

			if (findParent(node.from) != findParent(node.to)) {
				union(parentHouse, node.from, node.to);
				result += node.value;
				removeNode = node.value;
			}
		}
		return result - removeNode;
	}

	private static int findParent(int num) {
		if (parentHouse[num] == num) {
			return num;
		}
		return findParent(parentHouse[num]);
	}

	private static void union(int[] parentHouse, int y, int x) {
		int parentY = findParent(y);
		int parentX = findParent(x);

		if (parentY >= parentX) {
			parentHouse[parentY] = parentX;
		} else {
			parentHouse[parentX] = parentY;
		}
	}
}