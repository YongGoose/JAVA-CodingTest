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
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			times[i] = Long.parseLong(st.nextToken());
		}
		Arrays.sort(times);
		System.out.println(binarySearch(m));
	}

	static long binarySearch(int m) {
		long start = 0;
		long end = times[times.length - 1] * m;
		long result = Long.MAX_VALUE;
		while (start <= end) {
			long mid = (start + end) / 2;

			long cnt = calculatePerson(mid, m);
			if (cnt < m) {
				start = mid + 1;
			} else {
				result = Math.min(result, mid);
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