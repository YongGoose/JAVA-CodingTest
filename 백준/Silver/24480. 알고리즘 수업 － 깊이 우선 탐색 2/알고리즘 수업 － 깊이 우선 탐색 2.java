import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer>[] graph;
    static int count;
    static int[] result;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        result = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());

            graph[first].add(second);
            graph[second].add(first);
        }
        for (int i = 1; i < n + 1; i++) {
            graph[i].sort(Collections.reverseOrder());
        }
        count++;
        DFS(r);

        for (int i = 1; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

    static void DFS(int node) {
        visited[node] = true;
        result[node] = count;
        int length = graph[node].size();
        for (int i = 0; i < length; i++) {
            if (!visited[graph[node].get(i)]) {
                count++;
                DFS(graph[node].get(i));
            }
        }
    }
}