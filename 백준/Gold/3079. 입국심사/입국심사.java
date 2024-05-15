import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	private static long[] times;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		times = new long[n];
		long maxValue = 0;
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			long input = Long.parseLong(st.nextToken());
			
			maxValue = Math.max(maxValue, input);
			times[i] = input;
		}
		System.out.println(binarySearch(m, maxValue));
	}

	static long binarySearch(int m, long maxValue) {
		long start = 0;
		long end = maxValue * m;
		long result = 0;
		while (start <= end) {
			long mid = (start + end) / 2;

			long cnt = calculatePerson(mid, m);
			if (cnt < m) {
				start = mid + 1;
			} else {
				result = mid;
				end = mid - 1;
			}
		}
		return result;
	}

	static long calculatePerson(long time, int m) {
		long cnt = 0;
		for (long t : times) {
			if (cnt >= m) {
				break;
			}
			cnt += (time / t);
		}
		return cnt;
	}
}