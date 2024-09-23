import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	static class Node {
		int to;
		int length;

		public Node(final int to, final int length) {
			this.to = to;
			this.length = length;
		}
	}

	private static ArrayList<Node>[] nodes;
	private static int result;
	private static boolean[] isVisited;
	private static int target;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		nodes = new ArrayList[n + 1];
		for (int i = 1; i < n + 1; i++) {
			nodes[i] = new ArrayList<>();
		}

		for (int i = 0; i < n - 1; i++) {
			st = new StringTokenizer(br.readLine());

			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int len = Integer.parseInt(st.nextToken());

			nodes[from].add(new Node(to, len));
			nodes[to].add(new Node(from, len));
		}

		while (m-- > 0) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			target = Integer.parseInt(st.nextToken());

			isVisited = new boolean[n + 1];
			dfs(from, 0);

			System.out.println(result);
		}
	}

	private static void dfs(int curNum, int len) {
		if (curNum == target) {
			result = len;
			return;
		}

		isVisited[curNum] = true;
		for (Node n : nodes[curNum]) {
			int to = n.to;

			if (isVisited[to]) {
				continue;
			}

			dfs(to, len + n.length);
		}
	}
}
