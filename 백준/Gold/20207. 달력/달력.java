import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.StringTokenizer;

public class Main {

	private static int[] calendar = new int[1001];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int maxNum = 0;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			maxNum = Math.max(end, maxNum);

			for (int j = start; j < end + 1; j++) {
				calendar[j]++;
			}
		}

		int w = 0, h = 0;
		int result = 0;
		for (int i = 0; i < maxNum + 2; i++) {
			if (calendar[i] == 0) {
				result += w * h;
				w = 0;
				h = 0;
				continue;
			}

			w++;
			h = Math.max(h, calendar[i]);
		}
		System.out.println(result);
	}
}