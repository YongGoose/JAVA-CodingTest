import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] parent;
    static boolean[] isNodeExists;
    static boolean[] visited;
    static int n, result, rootNode;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        parent = new int[n];
        visited = new boolean[n];
        isNodeExists = new boolean[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(st.nextToken());
            if (number == -1) {
                rootNode = i;
            }
            parent[i] = number;
        }

        st = new StringTokenizer(br.readLine());
        int reNode = Integer.parseInt(st.nextToken());
        if (reNode == rootNode) {
            System.out.println(0);
            return;
        }
        isNodeExists[reNode] = true;
        removeNode(reNode);

        System.out.println(countNode(rootNode));
    }

    static void removeNode(int node) {
        for (int i = 0; i < n; i++) {
            if (parent[i] == node) {
                isNodeExists[i] = true;
                removeNode(i);
            }
        }
    }

    static int countNode(int idx) {
        visited[idx] = true;
        boolean hasChild = false;
        for (int i = 0; i < n; i++) {
            if (parent[i] == idx && !visited[i] && !isNodeExists[i]) {
                hasChild = true;
                countNode(i);
            }
        }
        if (!hasChild) {
            result++;
        }
        return result;
    }
}