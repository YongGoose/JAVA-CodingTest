import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		char[] inputArray = br.readLine().toCharArray();
		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < n; i++) {
			while (k > 0 && !stack.isEmpty() && stack.peek() < inputArray[i]) {
				stack.pop();
				k--;
			}
			stack.add(inputArray[i]);
		}
		StringBuilder sb = new StringBuilder();
		int idx = 0;
		while (stack.size() > k) {
			sb.append(stack.get(idx++));
			k++;
		}
		System.out.println(sb);
	}
}