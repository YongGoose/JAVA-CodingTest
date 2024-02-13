import java.io.*;
import java.util.*;

public class Main {
    static boolean[][] board;
    static boolean[][] visited;
    static int r, c, k, result;
    static int[] yMove = {1, -1, 0, 0};
    static int[] xMove = {0, 0, -1, 1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        board = new boolean[r][c];
        visited = new boolean[r][c];
        for (int i = 0; i < r; i++) {
            String input = br.readLine();
            for (int j = 0; j < c; j++) {
                if (input.charAt(j) == 'T') {
                    board[i][j] = true;
                }
            }
        }
        visited[r - 1][0] = true;
        dfs(r - 1, 0, 1);
        System.out.println(result);
    }

    static void dfs(int y, int x, int range) {

        if (range > k) {
            return;
        }

        if (range == k && y == 0 && x == c - 1) {
            result++;
            return;
        }


        for (int i = 0; i < 4; i++) {
            int updateY = yMove[i] + y;
            int updateX = xMove[i] + x;
            if (isOnBoard(updateY, updateX) && !board[updateY][updateX] && !visited[updateY][updateX]) {
                visited[updateY][updateX] = true;
                dfs(updateY, updateX, range + 1);
                visited[updateY][updateX] = false;
            }
        }
    }

    static boolean isOnBoard(int y, int x) {
        return y >= 0 && y < r && x >= 0 && x < c;
    }
}