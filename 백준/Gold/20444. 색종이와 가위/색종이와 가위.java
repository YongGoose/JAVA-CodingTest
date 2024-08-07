import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static long n;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Long.parseLong(st.nextToken());
		long k = Long.parseLong(st.nextToken());

		long start = 0;
		long end = n;

		while (start <= end) {
			long mid = (start + end) / 2;

			if (cutPaper(mid) == k) {
				System.out.println("YES");
				return;
			}

			if (cutPaper(mid) > k) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}

		}
		System.out.println("NO");
	}

	private static long cutPaper(long mid) {
		return (mid + 1) * (n - mid + 1);
	}
}