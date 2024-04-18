import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        ArrayList<Node>[] nodes = new ArrayList[n + 1];
        ArrayList<Node>[] reverseNodes = new ArrayList[n + 1];
        for (int i = 1; i < n + 1; i++) {
            nodes[i] = new ArrayList<>();
            reverseNodes[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            nodes[start].add(new Node(end, value));
            reverseNodes[end].add(new Node(start, value));
        }
        int[] homeToX = dijk(reverseNodes, x, n);
        int[] xToHome = dijk(nodes, x, n);

        int max = 0;
        for (int i = 1; i < n + 1; i++) {
            max = Math.max(max, homeToX[i] + xToHome[i]);
        }
        System.out.println(max);
    }

    static int[] dijk(ArrayList<Node>[] nodes, int x, int n) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(x, 0));

        boolean[] visited = new boolean[n + 1];
        int[] resultArray = new int[n + 1];
        Arrays.fill(resultArray, Integer.MAX_VALUE);
        resultArray[x] = 0;

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            visited[node.end] = true;

            for (Node gNode : nodes[node.end]) {
                if (resultArray[gNode.end] > resultArray[node.end] + gNode.value) {
                    resultArray[gNode.end] = resultArray[node.end] + gNode.value;
                    pq.add(new Node(gNode.end, gNode.value));
                }
            }
        }
        return resultArray;
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
            return this.value - o.value;
        }
    }
}