import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] map;
    static int n, m, result;
    static ArrayList<int[]> virus = new ArrayList<>();
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
                    virus.add(new int[]{i, j});
                }
                map[i][j] = value;
            }
        }
        createWall(0);
        System.out.println(result);
    }

    private static void createWall(int wall) {
        if (wall == 3) {
            bfs();
            return;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    createWall(wall + 1);
                    map[i][j] = 0;
                }
            }
        }
    }

    static void bfs() {
        Queue<int[]> viruses = new LinkedList<>(virus);
        int[][] fakemap = new int[n][m];
        for (int i = 0; i < n; i++) {
            fakemap[i] = map[i].clone();
        }

        while (!viruses.isEmpty()) {
            int[] vi = viruses.poll();

            for (int i = 0; i < 4; i++) {
                int ny = vi[0] + dy[i];
                int nx = vi[1] + dx[i];

                if (isOnBoard(ny, nx) && fakemap[ny][nx] == 0) {
                    fakemap[ny][nx] = 2;
                    viruses.add(new int[]{ny, nx});
                }
            }
        }
        calculateSateZone(fakemap);
    }

    static boolean isOnBoard(int y, int x) {
        return y >= 0 && x >= 0 && y < n && x < m;
    }

    static void calculateSateZone(int[][] fakemap) {
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (fakemap[i][j] == 0) {
                    cnt++;
                }
            }
        }
        result = Math.max(cnt, result);
    }
}