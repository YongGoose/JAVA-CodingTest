import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	private static ArrayList<ArrayList<Integer>> results = new ArrayList<>();
	private static int n, m;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		ArrayList<Integer> integers = new ArrayList<>();
		for (int i = 1; i < n - m + 2; i++) {
			integers.add(i);
			backTracking(1, integers, i);
			integers.remove(Integer.valueOf(i));
		}
		StringBuilder sb = new StringBuilder();
		for (ArrayList<Integer> arrayList : results) {
			for (int i : arrayList) {
				sb.append(i).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	private static void backTracking(int depth, ArrayList<Integer> integers, int value) {
		if (depth == m) {
			results.add(new ArrayList<>(integers));
			return;
		}

		for (int i = value + 1; i < n + 1; i++) {
			integers.add(i);
			backTracking(depth + 1, integers, i);
			integers.remove(Integer.valueOf(i));
		}
	}
}