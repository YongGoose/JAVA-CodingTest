import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Node>[] nodes;
    static int v, e, x;
    static int[] resultArray;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(br.readLine());

        nodes = new ArrayList[v + 1];
        resultArray = new int[v + 1];
        for (int i = 1; i < v + 1; i++) {
            nodes[i] = new ArrayList<>();
            resultArray[i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            nodes[start].add(new Node(end, value));
        }

        dijk();

        StringBuilder sb = new StringBuilder();
        for (int j = 1; j < v + 1; j++) {
            if (resultArray[j] == Integer.MAX_VALUE) {
                sb.append("INF").append("\n");
            } else {
                sb.append(resultArray[j]).append("\n");
            }
        }
        System.out.println(sb);
        br.close();
    }

    public static void dijk() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(x, 0));
        boolean[] visited = new boolean[v + 1];
        resultArray[x] = 0;

        while (!pq.isEmpty()) {
            Node node = pq.poll();

            if (!visited[node.end]) {
                visited[node.end] = true;
            }

            for (Node gNode : nodes[node.end]) {
                if (!visited[gNode.end] && resultArray[gNode.end] > resultArray[node.end] + gNode.value) {
                    resultArray[gNode.end] = resultArray[node.end] + gNode.value;
                    pq.add(new Node(gNode.end, resultArray[gNode.end]));
                }
            }
        }
    }

    static class Node implements Comparable<Node> {
        int end;
        int value;

        public Node(int end, int value) {
            this.end = end;
            this.value = value;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.value, o.value);
        }
    }
}
