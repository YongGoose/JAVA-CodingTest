import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] nodes;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        nodes = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            nodes[y].add(x);
        }
        for (int i = 0; i < n; i++) {
            Collections.sort(nodes[i]);
        }
        System.out.println(bfs(t));
    }

    static int bfs(int t) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0, 0, 0));

        while (!queue.isEmpty()) {

            Node node = queue.poll();
            if (node.y == t) {
                return node.cnt;
            }
            int my = node.y - 2;
            int py = node.y + 2;


            for (int i = my; i <= py; i++) {
                if (i < 0 || i > 200_001) {
                    continue;
                }

                for (int j = 0; j < nodes[i].size(); j++) {
                    if (node.x + 2 < nodes[i].get(j)) {
                        break;
                    } else if (node.x - 2 > nodes[i].get(j)) {
                        continue;
                    }

                    if (Math.abs(nodes[i].get(j) - node.x) <= 2) {
                        int x = nodes[i].remove(j);

                        queue.add(new Node(i, x, node.cnt + 1));
                        j--;
                    }
                }
            }
        }
        return -1;
    }


    static class Node {
        int y;
        int x;
        int cnt;

        public Node(int y, int x, int cnt) {
            this.y = y;
            this.x = x;
            this.cnt = cnt;
        }
    }
}