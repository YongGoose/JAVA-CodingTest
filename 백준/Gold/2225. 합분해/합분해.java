import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static final int MOD = 1_000_000_000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(st.nextToken()); // 합
        int k = Integer.parseInt(st.nextToken()); // 정수 개수

        int[][] memorization = new int[k + 1][n + 1];
        for (int i = 0; i < n + 1; i++) {
            memorization[1][i] = 1;
        }
        for (int i = 0; i < k + 1; i++) {
            memorization[i][0] = 1;
        }

        for (int i = 2; i < k + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                memorization[i][j] = (memorization[i - 1][j] + memorization[i][j - 1]) % MOD;
            }
        }
        bw.write(String.valueOf(memorization[k][n]));
        br.close();
        bw.flush();
        bw.close();
    }
}