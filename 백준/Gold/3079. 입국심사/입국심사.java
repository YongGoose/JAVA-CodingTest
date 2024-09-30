import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int[] array;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		array = new int[n];
		long maxValue = 0;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());

			array[i] = Integer.parseInt(st.nextToken());
			maxValue = Math.max(maxValue, array[i]);
		}

		long start = 1;
		long end = maxValue * m;

		long result = 0;

		while (start <= end) {
			long mid = (start + end) / 2;

			long curCount = calculateTime(mid, m);

			if (curCount >= m) {
				end = mid - 1;
				result = mid;
				continue;
			}

			start = mid + 1;
		}

		System.out.println(result);
	}

	private static long calculateTime(long time, int m) {
		long res = 0;

		for (int a : array) {
			if (res >= m) {
				break;
			}
			
			res += (time / a);
		}
		return res;
	}
}