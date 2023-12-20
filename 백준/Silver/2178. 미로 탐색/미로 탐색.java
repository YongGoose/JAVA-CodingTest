import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] missionArray;
    static int width;
    static int height;
    static int count = 1;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        height = Integer.parseInt(st.nextToken());
        width = Integer.parseInt(st.nextToken());
        missionArray = new int[height][width];
        visited = new boolean[height][width];

        for (int i = 0; i < height; i++) {
            String nums = br.readLine();
            for (int j = 0; j < width; j++) {
                visited[i][j] = false;
                missionArray[i][j] = Integer.parseInt(String.valueOf(nums.charAt(j)));
            }
        }
        BFS(0, 0);
        System.out.println(missionArray[height - 1][width - 1]);
    }

    static void BFS(int y, int x) {
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{y, x});
        visited[y][x] = true;
        while (!queue.isEmpty()) {
            int now[] = queue.poll();
            for (int i = 0; i < 4; i++) {
                int new_y = now[0] - dy[i];
                int new_x = now[1] - dx[i];
                if (isOnBox(new_y, new_x)) {
                    if (missionArray[new_y][new_x] != 0 && !visited[new_y][new_x]) {
                        visited[new_y][new_x] = true;
                        missionArray[new_y][new_x] = missionArray[now[0]][now[1]] + 1;
                        queue.add(new int[]{new_y, new_x});
                    }
                }
            }
        }
    }

    static boolean isOnBox(int y, int x) {
        if (y >= 0 && y < height && x >= 0 && x < width) {
            return true;
        } else {
            return false;
        }
    }
}