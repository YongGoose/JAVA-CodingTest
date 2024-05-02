import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] map;
    static int n, m, maxSafeZone;
    static ArrayList<int[]> viruses = new ArrayList<>();
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); // 세로
        m = Integer.parseInt(st.nextToken()); // 가로

        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int value = Integer.parseInt(st.nextToken());
                if (value == 2) {
                    viruses.add(new int[]{i, j});
                }
                map[i][j] = value;
            }
        }

        maxSafeZone = 0;
        dfs(0, 0);
        System.out.println(maxSafeZone);
    }

    static void dfs(int wallCnt, int start) {
        if (wallCnt == 3) {
            int[][] copyMap = Arrays.stream(map).map(int[]::clone).toArray(int[][]::new);
            bfs(copyMap);
            return;
        }

        for (int i = start; i < n * m; i++) {
            int y = i / m;
            int x = i % m;
            if (map[y][x] == 0) {
                map[y][x] = 1;
                dfs(wallCnt + 1, i + 1);
                map[y][x] = 0;
            }
        }
    }

    static void bfs(int[][] copyMap) {
        Queue<int[]> queue = new LinkedList<>(viruses);

        while (!queue.isEmpty()) {
            int[] virus = queue.poll();
            int y = virus[0];
            int x = virus[1];

            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if (ny >= 0 && ny < n && nx >= 0 && nx < m && copyMap[ny][nx] == 0) {
                    copyMap[ny][nx] = 2;
                    queue.offer(new int[]{ny, nx});
                }
            }
        }

        int safeZone = countSafeZone(copyMap);
        maxSafeZone = Math.max(maxSafeZone, safeZone);
    }

    static int countSafeZone(int[][] copyMap) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (copyMap[i][j] == 0) {
                    count++;
                }
            }
        }
        return count;
    }
}
