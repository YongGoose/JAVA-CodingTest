import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	private static int[][] people;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());

		long sum = 0;
		people = new int[n][2];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());

			people[i][0] = Integer.parseInt(st.nextToken());
			people[i][1] = Integer.parseInt(st.nextToken());
			sum += people[i][1];
		}
		
		Arrays.sort(people, Comparator.comparingInt(o -> o[0]));

		long cnt = 0;
		for (int i = 0; i < n; i++) {
			cnt += people[i][1];

			if (cnt >= (sum + 1) / 2) {
				System.out.println(people[i][0]);
				break;
			}
		}
		
	}
}