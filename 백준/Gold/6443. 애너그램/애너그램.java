import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	private static char[] word;
	private static int[] visited;
	private static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int testCase = Integer.parseInt(st.nextToken());
		while (testCase-- > 0) {
			st = new StringTokenizer(br.readLine());
			word = st.nextToken().toCharArray();
			visited = new int[26];

			for (char w : word) {
				visited[w - 'a']++;
			}
			dfs(word.length, "");
		}
		System.out.println(sb);
	}
	static void dfs(int length, String result) {
		if (result.length() == length) {
			sb.append(result).append("\n");
			return;
		}

		for (int i = 0; i < 26; i++) {
			if (visited[i] > 0) {
				visited[i]--;
				dfs(length, result + (char) (i + 'a'));
				visited[i]++;
			}
		}
	}
}