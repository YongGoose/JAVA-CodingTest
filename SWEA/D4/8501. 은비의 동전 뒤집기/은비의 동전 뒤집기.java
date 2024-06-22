import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	private static final int DIVIDE = 1_000_000_007;
	private static long[] multiple = new long[1_001];
	private static long[] resultArray = new long[1_001];
	public static void main(String[] args) throws IOException {
		multiple[1] = 1;
		for (int i = 2; i < 1_001; i++) {
			multiple[i] = (multiple[i - 1] * i) % DIVIDE;
		}

		resultArray[1] = 0;
		for (int i = 2; i < 1_001; i++) {
			resultArray[i] = ((i * resultArray[i - 1]) % DIVIDE + (i / 2 * multiple[i - 1]) % DIVIDE) % DIVIDE;
		}

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int testCase = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < testCase + 1; i++) {
			st = new StringTokenizer(br.readLine());
			sb.append("#").append(i).append(" ").append(resultArray[Integer.parseInt(st.nextToken())]).append("\n");
		}
		System.out.println(sb);
	}
}