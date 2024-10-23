import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		String missionString = st.nextToken();

		st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());

		Map<String, Integer> map = new HashMap<>();
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			int point = Integer.parseInt(st.nextToken());

			map.put(s, map.getOrDefault(s, point));
		}

		int length = missionString.length();
		int[] dp = new int[length + 1];

		for (int i = 1; i < length + 1; i++) {
			for (int j = 1; j < i + 1; j++) {
				String subMissionString = missionString.substring(j - 1, i);
				if (map.containsKey(subMissionString)) {
					dp[i] = Math.max(dp[i], dp[j - 1] + map.get(subMissionString));
					continue;
				}

				dp[i] = Math.max(dp[i], dp[i - 1] + 1);
			}
		}
		System.out.println(dp[length]);
	}
}