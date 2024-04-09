import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int houseNum = Integer.parseInt(st.nextToken());
        int roadNum = Integer.parseInt(st.nextToken());

        int[][] graph = new int[roadNum][3];
        for (int i = 0; i < roadNum; i++) {
            st = new StringTokenizer(br.readLine());
            graph[i][0] = Integer.parseInt(st.nextToken());
            graph[i][1] = Integer.parseInt(st.nextToken());
            graph[i][2] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(graph, (o1, o2) -> o1[2] - o2[2]);

        int[] parent = new int[houseNum + 1];
        for (int i = 1; i < houseNum + 1; i++) {
            parent[i] = i;
        }
        System.out.println(kruskal(graph, parent));
    }
    static int kruskal(int[][] graph, int[] parent) {
        int cost = 0, idx = 0;
        for (int i = 0; i < graph.length; i++) {
            if (findParent(parent, graph[i][0]) != findParent(parent, graph[i][1])) {
                idx = i;
                cost += graph[i][2];
                unionFind(parent, graph[i][0], graph[i][1]);
            }
        }
        cost -= graph[idx][2];
        return cost;
    }

    static void unionFind(int[] parent, int x1, int x2) {
        x1 = findParent(parent, x1);
        x2 = findParent(parent, x2);

        if (x1 < x2) {
            parent[x2] = x1;
        } else {
            parent[x1] = x2;
        }
    }
    static int findParent(int[] parent, int x) {
        if (parent[x] == x) {
            return x;
        }
        return findParent(parent, parent[x]);
    }
}