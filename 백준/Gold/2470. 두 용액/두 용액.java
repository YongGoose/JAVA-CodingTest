import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());

		int[] firstArray = new int[n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			firstArray[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(firstArray);

		int res1 = 0, res2 = 0;
		int left = 0, right = n - 1;
		int result = Integer.MAX_VALUE;

		while (left < right) {
			int f = firstArray[left];
			int s = firstArray[right];

			if (f + s == 0) {
				res1 = f;
				res2 = s;
				break;
			}

			if (f + s > 0) {
				right--;
			} else {
				left++;
			}

			if (Math.abs(f + s) < result) {
				result = Math.abs(f + s);
				res1 = f;
				res2 = s;
			}
		}

		System.out.println(res1 + " " + res2);
	}
}