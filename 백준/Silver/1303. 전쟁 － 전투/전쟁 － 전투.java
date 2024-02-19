import java.io.*;
import java.util.*;

public class Main {
    static int[][] board;
    static boolean[][] visited;
    static boolean[][] visited1;
    static int[] xMove = {0, 0, -1, 1};
    static int[] yMove = {-1, 1, 0, 0};
    static int n, m, result, result1, boardResult, boardResult1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new int[m][n];
        visited = new boolean[m][n];
        visited1 = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            String input = br.readLine();
            for (int j = 0; j < n; j++) {
                board[i][j] = input.charAt(j);
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result = 0;
                result1 = 0;
                calculateOutSolider(j, i);
                calculateTheirSolider(j, i);
                if (result == 0) {

                } else if (result == 1) {
                    boardResult += result;
                } else {
                    boardResult += result * result;
                }

                if (result1 == 0) {
                    
                } else if (result1 == 1) {
                    boardResult1 += result1;
                } else {
                    boardResult1 += result1 * result1;
                }
            }
        }
        System.out.println(boardResult + " " + boardResult1);
    }

    static void calculateOutSolider(int x, int y) {
        if (!(board[y][x] == 'W')) {
            return;
        }
        if (visited[y][x]) {
            return;
        }
        visited[y][x] = true;
        result += 1;
        for (int i = 0; i < 4; i++) {
            int nx = xMove[i] + x;
            int ny = yMove[i] + y;
            if (isOnBoard(nx, ny)) {
                calculateOutSolider(nx, ny);
            }
        }
    }

    static void calculateTheirSolider(int x, int y) {
        if (!(board[y][x] == 'B')) {
            return;
        }
        if (visited1[y][x]) {
            return;
        }
        visited1[y][x] = true;
        result1 += 1;
        for (int i = 0; i < 4; i++) {
            int nx = xMove[i] + x;
            int ny = yMove[i] + y;
            if (isOnBoard(nx, ny)) {
                calculateTheirSolider(nx, ny);;
            }
        }
    }

    static boolean isOnBoard(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }
}