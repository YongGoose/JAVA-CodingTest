import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	private static int[] array;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		array = new int[n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}

		int start = 0, end = n - 1;
		int minValue = Integer.MAX_VALUE;
		int minStart = 0, minEnd = 0;

		while (start < end) {
			int sum = array[start] + array[end];
			int absSum = Math.abs(sum);

			if (absSum <= minValue) {
				minValue = absSum;
				minStart = start;
				minEnd = end;
			}

			if (sum == 0) {
				minStart = start;
				minEnd = end;
				break;
			}

			if (sum > 0) {
				end--;
				continue;
			}
			start++;
		}

		System.out.println(array[minStart] + " " + array[minEnd]);
	}
}