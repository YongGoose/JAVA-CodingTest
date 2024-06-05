import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {
	static int[] numbers;
	static int n;
	static Set<Integer> set;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int testCase = Integer.parseInt(st.nextToken());
		for (int testNum = 0; testNum < testCase; testNum++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			numbers = new int[n];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				numbers[i] = Integer.parseInt(st.nextToken());
			}
			set = new HashSet<>();
			set.add(0);
			for (int i = 0; i < n; i++) {
				addNumbers(numbers[i]);
			}
			sb.append("#").append(testNum + 1).append(" ").append(set.size()).append("\n");
		}
		System.out.println(sb);
	}

	static void addNumbers(int num) {
		Set<Integer> newSet = new HashSet<>();
		newSet.addAll(set);

		for (Integer integer : newSet) {
			set.add(integer + num);
		}
	}
}