import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static char[][] board;
    static int n;
    static int answer = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        board = new char[n][n];

        for (int i = 0; i < n; i++) {
            String inputLine = br.readLine();
            for (int j = 0; j < n; j++) {
                board[i][j] = inputLine.charAt(j);
            }
        }
        for (int i = 0; i < n; i++) {
            findColumn(i);
            findRow(i);
        }


        for (int i = 0; i < n; i++) {
            for (int x = 0; x < n - 1; x++) {
                if (compareColor(board[i][x], board[i][x + 1])) {
                    swap(i, x, i, x + 1);
//                    System.out.println(board[i][x + 1] + "이거랑 " + board[i][x] + "바꿈" + i + "번째 줄에서");
                    findLongestX(i, x, x + 1);
                    swap(i, x, i, x + 1);
                }
            }

            for (int y = 0; y < n - 1; y++) {
                if (compareColor(board[y][i], board[y + 1][i])) {
                    swap(y, i, y + 1, i);
//                    System.out.println(board[y][i] + "이거랑 " + board[y + 1][i] + "바꿈" + i + "번째 줄에서");
                    findLongestY(i, y, y + 1);
                    swap(y, i, y + 1, i);
                }
            }
        }
        System.out.println(answer);
    }

    public static void findLongestX(int y, int x1, int x2) {
        //행 탐색
        findColumn(x1);
        findColumn(x2);
        findRow(y);
    }

    public static void findLongestY(int x, int y1, int y2) {
        //열 탐색
        findColumn(x);
        findRow(y1);
        findRow(y2);
    }

    public static void findColumn(int x) {
        int py = 1;
        for (int i = 0; i < n - 1; i++) {
            if (!compareColor(board[i][x], board[i + 1][x])) {
                py++;
            } else {
                answer = Math.max(answer, py);
                py = 1;
            }
        }
        answer = Math.max(answer, py);

    }

    public static void findRow(int y) {
        int px = 1;
        for (int i = 0; i < n - 1; i++) {
            if (!compareColor(board[y][i], board[y][i + 1])) {
                px++;
            } else {
                answer = Math.max(answer, px);
                px = 1;
            }
        }
        answer = Math.max(answer, px);
    }

    public static boolean compareColor(char e1, char e2) {
        return e1 != e2;
    }

    public static void swap(int y1, int x1, int y2, int x2) {
        char cmp;
        cmp = board[y1][x1];
        board[y1][x1] = board[y2][x2];
        board[y2][x2] = cmp;
    }
}