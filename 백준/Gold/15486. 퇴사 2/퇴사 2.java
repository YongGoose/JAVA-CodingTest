import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());

		int[] array = new int[n + 1];
		int max = 0;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());

			int t = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());

			max = Math.max(max, array[i]);

			if (i + t > n) {
				array[i] = max;
				continue;
			}

			array[i + t] = Math.max(max + p, array[i + t]);
		}
		System.out.println(Math.max(array[n - 1], array[n]));
	}
}