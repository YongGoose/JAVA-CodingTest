import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	private static ArrayList<Integer>[] list;
	private static int[] parent, depth;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int testCase = Integer.parseInt(st.nextToken());
		while (testCase-- > 0) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());

			parent = new int[n + 1];
			depth = new int[n + 1];
			list = new ArrayList[n + 1];
			for (int i = 1; i < n + 1; i++) {
				list[i] = new ArrayList<>();
			}

			boolean[] isVisited = new boolean[n + 1];

			for (int i = 0; i < n - 1; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				list[a].add(b);
				isVisited[b] = true;
			}

			int rootIdx = 0;
			for (int i = 1; i < n + 1; i++) {
				if (!isVisited[i]) {
					rootIdx = i;
					break;
				}
			}
			init(rootIdx, 1, 0);

			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			System.out.println(LCA(a, b));
		}
	}

	static void init(int cur, int h, int pa) {
		depth[cur] = h;
		parent[cur] = pa;
		for(int nxt : list[cur]) {
			if(nxt != pa) {
				init(nxt, h+1, cur);
			}
		}
	}

	static int LCA(int a, int b) {
		int ah = depth[a];
		int bh = depth[b];
		while(ah > bh) {
			a = parent[a];
			ah--;
		}

		while(bh > ah) {
			b = parent[b];
			bh--;
		}

		while(a!=b) {
			a = parent[a];
			b = parent[b];
		}

		return a;
	}
}