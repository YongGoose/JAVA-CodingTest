import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());

            if (m == 0 && n == 0) {
                break;
            }

            int[][] graph = new int[n][3];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                graph[i][0] = Integer.parseInt(st.nextToken());
                graph[i][1] = Integer.parseInt(st.nextToken());
                graph[i][2] = Integer.parseInt(st.nextToken());
            }
            int[] parent = new int[m];
            for (int i = 0; i < m; i++) {
                parent[i] = i;
            }
            Arrays.sort(graph, (o1, o2) -> o1[2] - o2[2]);

            System.out.println(kruskal(graph, parent));
        }
    }

    static int kruskal(int[][] graph, int[] parent) {
        int minusNum = 0;
        for (int i = 0; i < graph.length; i++) {
            if (findParent(parent, graph[i][0]) != findParent(parent, graph[i][1])) {
                union(parent, graph[i][0], graph[i][1]);
            } else {
                minusNum += graph[i][2];
            }
        }
        return minusNum;
    }

    static int findParent(int[] parent, int x) {
        if (parent[x] == x) {
            return x;
        }
        return findParent(parent, parent[x]);
    }

    static void union(int[] parent, int x, int y) {
        x = findParent(parent, x);
        y = findParent(parent, y);

        if (x < y) {
            parent[y] = x;
        } else {
            parent[x] = y;
        }
    }
}