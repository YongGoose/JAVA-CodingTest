import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	private static int[] points;
	private static int[] dif;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int k = Integer.parseInt(st.nextToken());

		points = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			points[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(points);

		dif = new int[n - 1];
		for (int i = 0; i < n - 1; i++) {
			dif[i] = points[i + 1] - points[i];
		}

		Arrays.sort(dif);
		int result = 0;
		for (int i = 0; i < n - k; i++) {
			result += dif[i];
		}

		System.out.println(result);
	}
}