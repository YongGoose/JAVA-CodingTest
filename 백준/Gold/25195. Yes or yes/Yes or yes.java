import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Integer>[] graph;
	static boolean[] isGomGom, isVisited;
	static int numNode;
	static int numLine;
	static boolean gameEnd = false;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		numNode = Integer.parseInt(st.nextToken());
		numLine = Integer.parseInt(st.nextToken());
		isGomGom = new boolean[numNode + 1];
		isVisited = new boolean[numNode + 1];
		graph = new ArrayList[numNode + 1];

		for (int i = 1; i <= numNode; i++) {
			graph[i] = new ArrayList<>();
		}
		for (int i = 0; i < numLine; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());

			graph[from].add(to);
		}

		st = new StringTokenizer(br.readLine());
		int s = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < s; i++) {
			int loc = Integer.parseInt(st.nextToken());
			isGomGom[loc] = true;
		}

		if (isGomGom[1]) {
			System.out.println("Yes");
			return;
		}

		dfs(1);

		System.out.println(gameEnd ? "yes" : "Yes");
	}
	
	private static void dfs(int currentNode) {
		boolean isEnd = true;

		for (int nextNode : graph[currentNode]) {
			if (isVisited[nextNode]) {
				continue;
			}

			isVisited[nextNode] = true;
			isEnd = false;

			if (!isGomGomHere(nextNode)) {
				dfs(nextNode);
			}
			isVisited[nextNode] = false;
		}

		if (isEnd) {
			gameEnd = true;
		}
	}

	private static boolean isGomGomHere(int node) {
		return Main.isGomGom[node];
	}
}
