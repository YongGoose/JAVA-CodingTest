import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int[] cnts = new int[100_001];
		Arrays.fill(cnts, -1);
		cnts[n] = 0;

		Deque<Integer> deque = new ArrayDeque<>();
		deque.offer(n);

		while (!deque.isEmpty()) {

			int dis = deque.pollFirst();

			if (dis == k) {
				break;
			}

			if (dis * 2 <= 100_000 && cnts[dis * 2] == -1) {
				cnts[dis * 2] = cnts[dis];
				deque.offerFirst(dis * 2);
			}

			if (dis - 1 >= 0 && cnts[dis - 1] == -1) {
				cnts[dis - 1] = cnts[dis] + 1;
				deque.offer(dis - 1);
			}

			if (dis + 1 <= 100_000 && cnts[dis + 1] == -1) {
				cnts[dis + 1] = cnts[dis] + 1;
				deque.offer(dis + 1);
			}
		}
		System.out.println(cnts[k]);
	}
}