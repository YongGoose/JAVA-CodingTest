import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int[][] map;
    private static ArrayList<int[]> notFresh = new ArrayList<>();
    private static int tomato, m, n;
    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int value = Integer.parseInt(st.nextToken());
                if (value == 1) {
                    notFresh.add(new int[]{i, j});
                } else if (value == 0) {
                    tomato++;
                }
                map[i][j] = value;
            }
        }
        System.out.println(bfs());
    }

    private static int bfs() {
        int count = -1, tomatoCnt = 0;
        Queue<int[]> tomatoes = new LinkedList<>(notFresh);
        while (!tomatoes.isEmpty()) {
            int length = tomatoes.size();
            for (int i = 0; i < length; i++) {
                int[] to = tomatoes.poll();
                int y = to[0];
                int x = to[1];

                for (int j = 0; j < 4; j++) {
                    int ny = y + dy[j];
                    int nx = x + dx[j];

                    if (!isOnBoard(ny, nx)) {
                        continue;
                    }
                    if (map[ny][nx] == 0) {
                        map[ny][nx] = 1;
                        tomatoCnt++;
                        tomatoes.add(new int[]{ny, nx});
                    }
                }
            }
            count++;
        }
        if (tomatoCnt != tomato) {
            count = -1;
        }
        return count;
    }

    private static boolean isOnBoard(int y, int x) {
        return y >= 0 && x >= 0 && y < n && x < m;
    }
}