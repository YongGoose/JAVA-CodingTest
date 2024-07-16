import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
    private static class Node implements Comparable<Node> {
        int to;
        int cost;

        public Node(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

    private static ArrayList<ArrayList<Node>> nodes = new ArrayList<>();
    private static int n, e;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        n = Integer.parseInt(input[0]);
        e = Integer.parseInt(input[1]);

        for (int i = 0; i <= n; i++) {
            nodes.add(new ArrayList<>());
        }
        for (int i = 0; i < e; i++) {
            input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            int c = Integer.parseInt(input[2]);

            nodes.get(a).add(new Node(b, c));
            nodes.get(b).add(new Node(a, c));
        }

        input = br.readLine().split(" ");
        int v1 = Integer.parseInt(input[0]);
        int v2 = Integer.parseInt(input[1]);

        int oneToV1 = dijkstra(1, v1);
        int oneToV2 = dijkstra(1, v2);
        int v1ToV2 = dijkstra(v1, v2);
        int v1ToN = dijkstra(v1, n);
        int v2ToN = dijkstra(v2, n);

        long result = Long.MAX_VALUE;
        boolean flag = false;

        if (oneToV1 != Integer.MAX_VALUE && v1ToV2 != Integer.MAX_VALUE && v2ToN != Integer.MAX_VALUE) {
            flag = true;
            result = Math.min(result, (long)oneToV1 + v1ToV2 + v2ToN);
        }

        if (oneToV2 != Integer.MAX_VALUE && v1ToV2 != Integer.MAX_VALUE && v1ToN != Integer.MAX_VALUE) {
            flag = true;
            result = Math.min(result, (long)oneToV2 + v1ToV2 + v1ToN);
        }

        System.out.println(flag ? result : -1);
    }
    
    private static int dijkstra(int from, int to) {
        boolean[] visited = new boolean[n + 1];
        int[] costs = new int[n + 1];
        Arrays.fill(costs, Integer.MAX_VALUE);
        costs[from] = 0;
        
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(from, 0));

        while (!pq.isEmpty()) {
            Node node = pq.poll();

            if (node.to == to) return node.cost;

            if (visited[node.to]) continue;
            visited[node.to] = true;

            for (Node n : nodes.get(node.to)) {
                if (!visited[n.to] && costs[n.to] > costs[node.to] + n.cost) {
                    costs[n.to] = costs[node.to] + n.cost;
                    pq.offer(new Node(n.to, costs[n.to]));
                }
            }
        }
        return costs[to];
    }
}