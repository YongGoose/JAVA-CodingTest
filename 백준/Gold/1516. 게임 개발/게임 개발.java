import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Objects;
import java.util.StringTokenizer;

public class Main {
	private static int[] resultArray;
	private static int[] dataArray;
	private static ArrayList<Integer>[] datas;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int testCase = Integer.parseInt(br.readLine());
		resultArray = new int[testCase + 1];
		datas = new ArrayList[testCase + 1];
		dataArray = new int[testCase + 1];
		for (int i = 1; i < testCase + 1; i++) {
			datas[i] = new ArrayList<>();
		}
		for (int i = 0; i < testCase; i++) {
			st = new StringTokenizer(br.readLine());
			dataArray[i + 1] = Integer.parseInt(st.nextToken());
			while (true) {
				String input = st.nextToken();
				if (input.equals("-1")) {
					break;
				}
				datas[i + 1].add(Integer.parseInt(input));
			}
		}
		for (int i = 1; i < testCase + 1; i++) {
			dp(i);
		}
		StringBuilder sb = new StringBuilder();

		for (int i = 1; i < testCase + 1; i++) {
			sb.append(resultArray[i]).append("\n");
		}
		System.out.println(sb);
	}

	static int dp(int n) {
		if (resultArray[n] != 0) {
			return resultArray[n];
		}

		ArrayList<Integer> integers = datas[n];
		int semi = 0;
		for (int i : integers) {
			semi = Math.max(dp(i), semi);
		}
		return resultArray[n] = semi + dataArray[n];
	}
}