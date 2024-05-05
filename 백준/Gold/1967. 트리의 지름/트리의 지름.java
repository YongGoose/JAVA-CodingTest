import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Node>[] graph;
    static boolean[] visited;
    static int maxValue = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int nodeCnt = Integer.parseInt(st.nextToken());

        graph = new ArrayList[nodeCnt + 1];

        for (int i = 1; i < nodeCnt + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < nodeCnt - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            int length = Integer.parseInt(st.nextToken());

            graph[parent].add(new Node(child, length));
            graph[child].add(new Node(parent, length));
        }

        for (int i = 1; i < nodeCnt; i++) {
            visited = new boolean[nodeCnt + 1];
            dfs(i, 0);
        }
        System.out.println(maxValue);
    }

    static void dfs(int num, int value) {
        visited[num] = true;
        maxValue = Math.max(maxValue, value);

        for (Node node : graph[num]) {
            if (!visited[node.child]) {
                dfs(node.child, value + node.length);
            }
        }
    }

    static class Node {
        int child;
        int length;

        public Node(int child, int length) {
            this.child = child;
            this.length = length;
        }
    }
}