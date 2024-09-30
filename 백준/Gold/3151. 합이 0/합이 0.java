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

		Arrays.sort(array);
		long answer = 0;

		for (int i = 0; i < n; i++) {
			if (array[i] > 0) {
				break;
			}

			int start = i + 1;
			int end = n - 1;


			while (start < end) {
				int s = 1;
				int e = 1;

				int cur = array[i] + array[start] + array[end];
				if (cur == 0) {
					if (array[start] == array[end]) {
						answer += comb(end - start + 1);
						break;
					}

					while (start + 1 < end && array[start + 1] == array[start]) {
						s++;
						start++;
					}

					while (start < end - 1 && array[end] == array[end - 1]) {
						e++;
						end--;
					}

					answer += s * e;
				}

				if (cur > 0) {
					end--;
				} else start++;
			}
		}
		System.out.println(answer);
	}

	private static int comb(int n) {
		return n * (n - 1) / 2;
	}
}