import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	private static int[] shootingSpot;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int m = Integer.parseInt(st.nextToken()); // 사대의 수
		int n = Integer.parseInt(st.nextToken()); // 동물의 수
		int l = Integer.parseInt(st.nextToken()); // 사정거리

		shootingSpot = new int[m];
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < m; i++) {
			shootingSpot[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(shootingSpot);

		int count = 0;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());

			int ax = Integer.parseInt(st.nextToken());
			int ay = Integer.parseInt(st.nextToken());

			if (ay > l) {
				continue;
			}

			int left = 0;
			int right = m - 1;

			while (left < right) {
				int mid = (left + right) / 2;

				if (shootingSpot[mid] < ax) {
					left = mid + 1;
				} else {
					right = mid;
				}
			}

			if ((Math.abs(shootingSpot[right] - ax) + ay) <= l) {
				count++;
			}
		}

		System.out.println(count);
	}
}