import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static boolean[][] board;
    static boolean[][] visited;
    static int m, n;
    static int[][] movement = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken()); // 세로
        n = Integer.parseInt(st.nextToken()); // 가로
        board = new boolean[m][n];
        visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            String input = br.readLine();
            for (int j = 0; j < n; j++) {
                char num = input.charAt(j);
                board[i][j] = canElectricityFlows(num);
            }
        }
        for (int i = 0; i < n; i++) {
            if (board[0][i]) {
                if (dfs(0, i)) {
                    System.out.println("YES");
                    return;
                }
            }
        }
        System.out.println("NO");
    }

    static boolean canElectricityFlows(char input) {
        return input == '0';
    }

    static boolean dfs(int y, int x) {
        visited[y][x] = true;
        if (y == m - 1) {
            return true;
        }

        for (int i = 0; i < movement.length; i++) {
            int newY = movement[i][0] + y;
            int newX = movement[i][1] + x;

            if (isOnBoard(newY, newX) && !visited[newY][newX]) {
                if (dfs(newY, newX)) {
                    return true;
                }
            }
        }
        return false;
    }

    static boolean isOnBoard(int y, int x) {
        return y >= 0 && x >= 0 && y < m && x < n && board[y][x];
    }
}