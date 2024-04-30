import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int[][] numberArray;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        numberArray = new int[n + 1][m + 1];
        for (int i = 1; i < n + 1; i++) {
            String input = br.readLine();
            for (int j = 1; j < m + 1; j++) {
                numberArray[i][j] = input.charAt(j - 1) - '0';
            }
        }
        System.out.println(dp(n, m));
    }

    static int dp(int n, int m) {
        int maxNumber = 0;
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (numberArray[i][j] == 1) {
                    numberArray[i][j] = Math.min(numberArray[i][j - 1], Math.min(numberArray[i - 1][j], numberArray[i - 1][j - 1])) + 1;
                } else {
                    numberArray[i][j] = 0;
                }
                maxNumber = Math.max(maxNumber, numberArray[i][j]);
            }
        }

        return maxNumber * maxNumber;
    }
}