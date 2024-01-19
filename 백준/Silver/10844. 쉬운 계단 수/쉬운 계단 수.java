import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] numbers;
    static final int mod = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        numbers = new int[n + 1][10];

        for (int i = 1; i <= 9; i++) {
            numbers[1][i] = 1;
        }
        if (n == 1) {
            System.out.println(9);
        } else {
            /*
            끝자리가 0, 9이면 전 단계의 1, 8도 대체 가능
            0, 9이면 1, 8밖에 오지 못하기 때문이다.
            그러므로 전 단계의 1과 8도 대체 가능하다.
             */
            for (int i = 2; i <= n; i++) {
                for (int j = 0; j <= 9; j++) {
                    if (j == 0) {
                        numbers[i][j] = numbers[i - 1][1] % mod;
                    } else if (j == 9) {
                        numbers[i][j] = numbers[i - 1][8] % mod;
                    } else {
                        numbers[i][j] = (numbers[i - 1][j - 1] + numbers[i - 1][j + 1]) % mod;
                    }
                }
            }
            int result = 0;
            for (int i = 0; i < 10; i++) {
                result = (result + numbers[n][i]) % mod;
            }
            System.out.println(result);
        }

    }
}