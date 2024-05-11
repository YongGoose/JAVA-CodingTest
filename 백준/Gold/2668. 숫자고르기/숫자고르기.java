import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    static ArrayList<Integer> result = new ArrayList<>();
    static boolean[] visited;
    static int[] numbers;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        numbers = new int[n + 1];
        visited = new boolean[n + 1];

        for (int i = 1; i < n + 1; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 1; i < n + 1; i++) {
            visited[i] = true;
            dfs(i, i);
            visited[i] = false;
        }
        Collections.sort(result);
        StringBuilder sb = new StringBuilder();
        sb.append(result.size()).append("\n");
        for (Integer res : result) {
            sb.append(res).append("\n");
        }
        System.out.println(sb);
    }

    static void dfs(int start, int target) {
        if (start == numbers[target]) {
            result.add(start);
        }

        if (!visited[numbers[target]]) {
            visited[target] = true;
            dfs(start, numbers[target]);
            visited[target] = false;
        }
    }
}