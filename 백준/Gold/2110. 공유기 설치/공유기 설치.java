import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[] houses;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		houses = new int[n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			houses[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(houses);

		System.out.println(binarySearch(1, houses[houses.length - 1] - houses[0], c));

	}

	static int binarySearch(int min, int max, int c) {
		int start = min;
		int end = max;
		int result = 0;

		while (start <= end) {
			int mid = (start + end) / 2;

			int cnt = calculateHouse(mid);
			if (cnt >= c) {
				result = mid;
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		return result;
	}

	static int calculateHouse(int mid) {
		int cnt = 1;
		int firstHouse = houses[0];

		for (int house : houses) {
			if (firstHouse + mid <= house) {
				firstHouse = house;
				cnt++;
			}
		}
		return cnt;
	}
}