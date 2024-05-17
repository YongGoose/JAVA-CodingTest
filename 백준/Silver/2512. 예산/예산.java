import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[] cities;
	static int maxNumber;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int nums = Integer.parseInt(st.nextToken());
		cities = new int[nums];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < nums; i++) {
			cities[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(cities);

		maxNumber = Integer.parseInt(br.readLine());

		int start = 0;
		int end = cities[cities.length - 1];
		int answer = 0;
		while (start <= end) {
			int mid = (start + end) / 2;

			long result = calculateCities(mid);

			if (result <= maxNumber) {
				answer = mid;
				start += 1;
			} else {
				end -= 1;
			}
		}
		if (answer > cities[cities.length - 1]) {
			answer = cities[cities.length - 1];
		}
		System.out.println(answer);
	}

	static long calculateCities(int mid) {
		long result = 0;

		for (int city : cities) {
			if (result > maxNumber) {
				return result;
			}
			if (mid >= city) {
				result += city;
				continue;
			}
			result += mid;
		}
		return result;
	}
}