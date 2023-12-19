import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer> arrays[];
    static boolean[] visited;
    static int count = 0;
    static boolean arrived;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arrays = new ArrayList[n];
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            arrays[i] = new ArrayList<>();
            visited[i] = false;
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int last = Integer.parseInt(st.nextToken());

            arrays[first].add(last);
            arrays[last].add(first);
        }
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                count++;
                DFS(i, 1);
            }
        }
        if (arrived) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    static void DFS(int i, int depth) {
        if (depth == 5 || arrived) {
            arrived = true;
            return;
        }
        visited[i] = true;
        for (int number : arrays[i]) {
            if (!visited[number]) {
                DFS(number, depth + 1);
            }
        }
        visited[i] = false;
    }
}
