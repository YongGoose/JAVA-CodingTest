import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		char[] inputArray = br.readLine().toCharArray();
		Deque<Character> deque = new ArrayDeque<>();

		for (int i = 0; i < n; i++) {
			while (k > 0 && !deque.isEmpty() && deque.peekLast() < inputArray[i]) {
				deque.pollLast();
				k--;
			}
			deque.add(inputArray[i]);
		}

		StringBuilder sb = new StringBuilder();
		while (deque.size() > k) {
			sb.append(deque.pop());
		}
		System.out.println(sb);
	}
}