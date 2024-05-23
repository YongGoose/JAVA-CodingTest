import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 강의실_배정 {
	static PriorityQueue<Class> pq = new PriorityQueue<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());

			pq.add(new Class(start, end));
		}

		int result = 1;
		Class firstClass = pq.poll();

		while (!pq.isEmpty()) {
			Class c = pq.poll();

			if (c.start >= firstClass.end) {
				firstClass = c;
				result++;
			}
		}
		System.out.println(result);
	}

	public static class Class implements Comparable<Class> {
		int start;
		int end;

		public Class(int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Class o) {
			if (this.end == o.end) {
				return this.start - o.start;
			}

			return this.end - o.end;
		}
	}
}