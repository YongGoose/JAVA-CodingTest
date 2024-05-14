import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(st.nextToken());

		Stack<Tower> stack = new Stack<>();
		st = new StringTokenizer(br.readLine());

		/*
		1. stack이 비어있는 경우
		stack에 새로운 tower를 넣는다. 그리고 0을 출력한다.

		2. stack이 비어있지 않은 경우
		현재 tower의 위치보다 stack의 가장 앞 tower가 더 크면 그 tower의 인덱스 출력

		 */
		for (int i = 1; i < n + 1; i++) {
			int height = Integer.parseInt(st.nextToken());
			if (stack.isEmpty()) {
				sb.append(0).append(" ");
				stack.add(new Tower(height, i));
			} else {
				boolean flag = true;
				while (!stack.isEmpty()) {
					Tower tower = stack.peek();
					if (tower.height < height) {
						stack.pop();
					} else {
						sb.append(tower.idx).append(" ");
						stack.add(new Tower(height, i));
						flag = false;
						break;
					}
				}
				if (flag) {
					sb.append(0).append(" ");
					stack.add(new Tower(height, i));
				}
			}
		}
		System.out.println(sb);
	}

	static class Tower {
		int height;
		int idx;

		public Tower(int height, int idx) {
			this.height = height;
			this.idx = idx;
		}
	}
}