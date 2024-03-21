import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static boolean[][] array1;
    static boolean[][] array2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        array1 = new boolean[n][m];
        array2 = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < m; j++) {
                array1[i][j] = checkWord(input.charAt(j));
            }
        }

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < m; j++) {
                array2[i][j] = checkWord(input.charAt(j));
            }
        }

        int cnt = 0;
        for (int i = 0; i < n - 2; i++) {
            for (int j = 0; j < m - 2; j++) {
                if (array1[i][j] != array2[i][j]) {
                    changeArray(i, j);
                    cnt++;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (array1[i][j] != array2[i][j]) {
                    System.out.println(-1);
                    return;
                }
            }
        }
        System.out.println(cnt);
    }

    static boolean checkWord(char number) {
        return number == '1';
    }

    static void changeArray(int y, int x) {
        for (int i = y; i < y + 3; i++) {
            for (int j = x; j < x + 3; j++) {
                array1[i][j] = !array1[i][j];
            }
        }
    }
}