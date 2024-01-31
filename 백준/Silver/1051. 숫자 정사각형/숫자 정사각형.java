import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static char[][] numbers;
    static int maxNum = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        numbers = new char[n][m];
        if (n == 1) {
            System.out.println("1");
            return;
        }
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < m; j++) {
                numbers[i][j] = input.charAt(j);
            }
        }
        int range = Math.min(n, m);
        
        while (range > 1) {
            for (int i = 0; i <= n - range; i++) {
                for (int j = 0; j <= m - range; j++) {
                    char exp = numbers[i][j];

                    if (numbers[i + range - 1][j] == exp && numbers[i + range - 1][j + range - 1] == exp
                            && numbers[i][j + range - 1] == exp) {
                        maxNum = Math.max(maxNum, range * range);
                    }
                }
            }
            range--;
        }
        if (maxNum == Integer.MIN_VALUE) {
            System.out.println("1");
        } else {
            System.out.println(maxNum);
        }
    }
}
