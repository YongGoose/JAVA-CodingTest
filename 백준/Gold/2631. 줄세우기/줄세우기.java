import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int[] arr = new int[n];
		int[] length = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		for (int i = 0; i < n; i++) {
			length[i] = 1;

			for (int j = 0; j < i; j++) {
				if (arr[j] < arr[i]) {
					length[i] = Math.max(length[i], length[j] + 1);
				}
			}
		}

		Arrays.sort(length);
		System.out.println(n - length[n - 1]);
	}
}