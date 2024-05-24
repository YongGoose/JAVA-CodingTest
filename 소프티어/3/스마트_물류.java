import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 스마트_물류 {
	static char[] line;
	static int n, k;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		line = br.readLine().toCharArray();

		int result = 0;
		for (int i = 0; i < n; i++) {
			if (line[i] == 'P') {
				for (int j = i - k; j < i + k + 1; j++) {
					if (j < 0 || j >= n) {
						continue;
					}

					if (line[j] == 'H') {
						line[j] = '0';
						result++;
						break;
					}
				}
			}
		}
		System.out.println(result);
	}
}