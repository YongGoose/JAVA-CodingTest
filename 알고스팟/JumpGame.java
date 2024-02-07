import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] gameBoard;
    static int[][] cache;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int testCase = Integer.parseInt(st.nextToken());
        while (testCase-- > 0) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            gameBoard = new int[n][n];
            cache = new int[n][n];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    gameBoard[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            dp(0, 0);
            if (cache[n - 1][n - 1] == 1) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    static void dp(int y, int x) {
        /*
        만약 보드를 나가게 되면 return하여 종료시킨다.
         */
        if (isOnBoard(x, y)) {
            return;
        }
        /*
        탈출 지점에 도달하게 되면 cache[n-1][n-1]의 값을 1로 하고 return 한다.
         */
        if (x == n - 1 && y == n - 1) {
            cache[n - 1][n - 1] = 1;
        }
        /*
        cache의 초기값이 0이므로 방문하지 않았을 때만 계산하도록 구현한다.
         */
        if (cache[y][x] == 0) {
            cache[y][x] = -1;
            int boardNumber = gameBoard[y][x];
            dp(y + boardNumber, x);
            dp(y, x + boardNumber);
        }
    }

    static boolean isOnBoard(int x, int y) {
        return x >= n || y >= n || x < 0 || y < 0;
    }
}