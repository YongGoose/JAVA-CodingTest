import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.StringTokenizer;

public class 효도_음식 {
	static int[] foods;
	static int[] forwordResult;
	static int[] reverseResult;
	static int n;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		foods = new int[n];
		forwordResult = new int[n];
		reverseResult = new int[n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			foods[i] = Integer.parseInt(st.nextToken());
		}
		forwordResult[0] = foods[0];
		reverseResult[n - 1] = foods[n - 1];
		dp();
		reverseDp();

		int minValue = -1000000;
		for (int i = 1; i < n - 1; i++) {
			int first = forwordResult[i - 1];
			int second = reverseResult[i + 1];

			minValue = Math.max(minValue, first + second);
		}
		System.out.println(minValue);
	}

	static void dp() {
		int currentMax = foods[0];

		for (int i = 1; i < n; i++) {
			currentMax = Math.max(foods[i], currentMax + foods[i]);
			forwordResult[i] = Math.max(forwordResult[i - 1], currentMax);
		}
	}

	static void reverseDp() {
		int currentMax = foods[n - 1];
		for (int i = n - 2; i >= 0; i--) {
			currentMax = Math.max(foods[i], currentMax + foods[i]);
			reverseResult[i] = Math.max(reverseResult[i + 1], currentMax);
		}
	}
}