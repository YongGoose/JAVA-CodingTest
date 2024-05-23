import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 성적_평균 {
	static int[] students;
	static int[] score;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		students = new int[n];
		score = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			students[i] = Integer.parseInt(st.nextToken());
		}

		score[0] = students[0];

		for (int i = 1; i < n; i++) {
			score[i] = score[i - 1] + students[i];
		}

		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			int first = Integer.parseInt(st.nextToken()) - 1;
			int last = Integer.parseInt(st.nextToken()) - 1;

			int result = score[last] - score[first] + students[first];
			System.out.printf("%.2f\n", (double) result / (last - first + 1));
		}
	}
}