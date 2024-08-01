import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int maxCount = 0, n;
	private static int[] honeys;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());

		honeys = new int[n];
		int total = 0;
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; i++) {
			honeys[i] = Integer.parseInt(st.nextToken());
			total += honeys[i];
		}

		leftHoney(total);
		rightHoney(total);
		middleHoney(total);

		System.out.println(maxCount);
	}

	private static void rightHoney(int total) {
		total -= honeys[0];
		int secondBee = total;

		for (int i = 1; i < n; i++) {
			secondBee -= honeys[i];

			maxCount = Math.max(maxCount, secondBee + total - honeys[i]);
		}
	}

	private static void leftHoney(int total) {
		total -= honeys[n - 1];
		int secondBee = total;
		for (int i = n - 2; i >= 0; i--) {
			secondBee -= honeys[i];

			maxCount = Math.max(maxCount, secondBee + total - honeys[i]);
		}
	}

	private static void middleHoney(int total) {
		total -= honeys[0];
		total -= honeys[n - 1];

		for (int i = 1; i < n - 1; i++) {
			maxCount = Math.max(maxCount, total + honeys[i]);
		}
	}
}