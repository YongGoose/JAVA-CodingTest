import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		long[] arr = new long[n];
		st = new StringTokenizer(br.readLine());
		arr[0] = Long.parseLong(st.nextToken());

		for (int i = 1; i < n; i++) {
			arr[i] = arr[i - 1] + Long.parseLong(st.nextToken());
		}

		HashMap<Long, Long> map = new HashMap<>();
		long answer = 0;

		for (int i = 0; i < n; i++) {
			if (arr[i] == k) {
				answer++;
			}

			answer += map.getOrDefault(arr[i] - k, (long)0);
			map.put(arr[i], map.getOrDefault(arr[i], (long)0) + 1);
		}
		System.out.println(answer);
	}
}