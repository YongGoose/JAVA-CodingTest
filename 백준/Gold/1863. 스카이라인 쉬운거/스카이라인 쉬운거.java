import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());

		int[][] buildings = new int[n + 1][2];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());

			buildings[i][0] = Integer.parseInt(st.nextToken());
			buildings[i][1] = Integer.parseInt(st.nextToken());
		}

		int count = 0;
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < n + 1; i++) {
			int currentBuilding = buildings[i][1];

			while (!stack.isEmpty() && stack.peek() > currentBuilding) {
				stack.pop();
				count++;
			}

			if (!stack.isEmpty() && stack.peek() == currentBuilding) {
				continue;
			}
			stack.push(currentBuilding);
		}

		System.out.println(count);
	}
}