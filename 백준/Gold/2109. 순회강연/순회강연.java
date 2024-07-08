import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	private static PriorityQueue<int[]> lecture;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());

		lecture = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[0] == o2[0]) {
					return o1[1] - o2[1];
				}
				return o2[0] - o1[0];
			}
		});
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());

			int price = Integer.parseInt(st.nextToken());
			int day = Integer.parseInt(st.nextToken());

			lecture.offer(new int[] {price, day});
		}

		int result = 0;
		int[] array = new int[10_001];
		for (int i = 0; i < n; i++) {
			int[] currentLecture = lecture.poll();

			int date = currentLecture[1];
			int price = currentLecture[0];

			for (int j = date; j >= 1; j--) {
				if (array[j] == 0) {
					array[j] = price;
					result += price;
					break;
				}
			}
		}

		System.out.println(result);
	}
}