import java.io.*;
import java.util.*;

public class 함께하는_효도 {
    private static int[][] map;
    private static ArrayList<Node> nodes = new ArrayList<>();
    private static boolean[][] visited;
    private static int result, n, m;
    private static int[] dx = {0, 0, -1 ,1};
    private static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][n];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        visited = new boolean[n][n];

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int y = Integer.parseInt(st.nextToken()) - 1;
            int x = Integer.parseInt(st.nextToken()) - 1;
            visited[y][x] = true;
            nodes.add(new Node(y, x, map[y][x]));
        }
        dfs(0, 0, nodes.get(0), map[nodes.get(0).y][nodes.get(0).x]);
        System.out.println(result);
    }

    static void dfs(int depth, int idx, Node node, int value) {
        if(idx == 3) {
            if(depth < m - 1) {
                Node nextNode = nodes.get(depth + 1);
                dfs(depth + 1, 0, nextNode, value + map[nextNode.y][nextNode.x]);
                return;
            }
            result = Math.max(result, value);
            return;
        }

        for(int i = 0; i < 4; i++) {
            int nx = node.x + dx[i];
            int ny = node.y + dy[i];

            if(!isOnBoard(ny, nx)) {
                continue;
            }
            if(visited[ny][nx]) {
                continue;
            }

            visited[ny][nx] = true;
            dfs(depth, idx + 1, new Node(ny, nx, map[ny][nx]), value + map[ny][nx]);
            visited[ny][nx] = false;
        }

    }

    static boolean isOnBoard(int y, int x) {
        return y >= 0 && y < n && x >= 0 && x < n;
    }

    static class Node {
        int y, x, value;

        public Node (int y, int x, int value) {
            this.y = y;
            this.x = x;
            this.value = value;
        }
    }
}