import java.io.*;
import java.util.*;

public class Main {
	static class Pos {
		int x, dist;

		Pos(int x, int dist) {
			this.x = x;
			this.dist = dist;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		Queue<Pos> q = new LinkedList<>();
		Set<Integer> visited = new HashSet<>();

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int x = Integer.parseInt(st.nextToken());
			q.offer(new Pos(x, 0));
			visited.add(x);
		}

		long answer = 0;
		int count = 0;
		int[] dx = {-1, 1};

		while (!q.isEmpty() && count < K) {
			Pos cur = q.poll();

			for (int dir = 0; dir < 2; dir++) {
				int nx = cur.x + dx[dir];
				if (visited.contains(nx)) continue;

				visited.add(nx);
				answer += cur.dist + 1;
				count++;

				if (count == K) break;
				q.offer(new Pos(nx, cur.dist + 1));
			}
		}

		System.out.println(answer);
	}
}