import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static boolean[] isBroken = new boolean[10];
	private static int minCount = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int target = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());

		if (m > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < m; i++) {
				isBroken[Integer.parseInt(st.nextToken())] = true;
			}
		}

		minCount = Math.abs(target - 100); // 초기값: +/- 버튼만 사용

		if (m < 10) { // 모든 버튼이 고장난 경우는 제외
			dfs(0, 0, target);
		}

		System.out.println(minCount);
	}

	private static void dfs(int num, int count, int target) {
		if (count > 6) return; // 500,000까지 고려, 최대 6자리

		if (count > 0) {
			int press = count + Math.abs(target - num);
			minCount = Math.min(minCount, press);
		}

		for (int i = 0; i < 10; i++) {
			if (!isBroken[i]) {
				int nextNum = num * 10 + i;
				dfs(nextNum, count + 1, target);
			}
		}
	}
}