import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static char[][] board;
    static int x, y;
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        board = new char[n][m];

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = input.charAt(j);
            }
        }

        for (y = 0; y <= n - 8; y++) {
            for (x = 0; x <= m - 8; x++) {
                int res;
                res = Math.min(checkColor('B'), checkColor('W'));
                result = Math.min(res, result);
            }
        }
        System.out.println(result);
    }

    static int checkColor(char color) {
        int checkResult = 0;
        char secondColor;
        if (color == 'B') {
            secondColor = 'W';
        } else {
            secondColor = 'B';
        }

        int count = 0;
        for (int i = y; i < y + 8; i++) {
            if (count % 2 == 0) {
                for (int j = x; j < x + 8; j += 2) {
                    if (board[i][j] != color) {
                        checkResult++;
                    }
                }
                for (int j = x + 1; j < x + 8; j += 2) {
                    if (board[i][j] != secondColor) {
                        checkResult++;
                    }
                }
            } else {
                for (int j = x; j < x + 8; j += 2) {
                    if (board[i][j] != secondColor) {
                        checkResult++;
                    }
                }
                for (int j = x + 1; j < x + 8; j += 2) {
                    if (board[i][j] != color) {
                        checkResult++;
                    }
                }
            }
            count++;
        }
        return checkResult;
    }
}
