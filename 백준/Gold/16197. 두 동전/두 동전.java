import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.spec.RSAOtherPrimeInfo;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static boolean[][] board;
    static ArrayList<Coin> coins = new ArrayList<>();
    static int[][] dMove = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
    static boolean[][][][] visited;
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); // 세로
        m = Integer.parseInt(st.nextToken()); // 가로

        board = new boolean[n][m];
        visited = new boolean[n][m][n][m];
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < m; j++) {
                char inputChar = input.charAt(j);
                if (inputChar == 'o') {
                    coins.add(new Coin(j, i));
                }
                board[i][j] = (inputChar == '#');
            }
        }
        System.out.println(bfs());
    }

    static int bfs() {
        Queue<Coin> coins1 = new LinkedList<>();
        Queue<Coin> coins2 = new LinkedList<>();
        coins1.add(coins.get(0));
        coins2.add(coins.get(1));

        while (!coins1.isEmpty() || !coins2.isEmpty()) {
            Coin firstCoin = coins1.poll();
            Coin secondCoin = coins2.poll();
            if (firstCoin.count + 1 > 10) {
                break;
            }

            visited[firstCoin.y][firstCoin.x][secondCoin.y][secondCoin.x] = true;

            for (int[] ints : dMove) {
                int x1 = firstCoin.x + ints[1];
                int y1 = firstCoin.y + ints[0];

                int x2 = secondCoin.x + ints[1];
                int y2 = secondCoin.y + ints[0];

                if (canMove(x1, y1)) {
                    x1 = firstCoin.x;
                    y1 = firstCoin.y;
                }
                if (canMove(x2, y2)) {
                    x2 = secondCoin.x;
                    y2 = secondCoin.y;
                }
                int result = 0;
                if (coinDropped(x1, y1)) {
                    result += 1;
                }
                if (coinDropped(x2, y2)) {
                    result += 1;
                }

                if (result == 1) {
                    return firstCoin.count + 1;
                } else if (result == 2 && !visited[y1][x1][y2][x2]) {
                    visited[y1][x1][y2][x2] = true;
                    coins1.offer(new Coin(x1, y1, firstCoin.count + 1));
                    coins2.offer(new Coin(x2, y2, secondCoin.count + 1));
                }
            }
        }
        return -1;
    }

    static boolean canMove(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n && board[y][x];
    }

    static boolean coinDropped(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }

    static class Coin {
        int x;
        int y;
        int count;

        public Coin(int x, int y) {
            this.x = x;
            this.y = y;
            count = 0;
        }

        public Coin(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
}