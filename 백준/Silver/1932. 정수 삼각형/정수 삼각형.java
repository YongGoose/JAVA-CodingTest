import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int[][] triangle;
    static int[][] cache;
    static int n;
    static ArrayList<Integer> results = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        triangle = new int[n][n];
        cache = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < i + 1; j++) {
                triangle[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int result = dp(0, 0);
        System.out.println(result);
    }

    static int dp(int y, int x) {
        if (y >= n - 1) {
            return triangle[y][x];
        }
        if (cache[y][x] != 0) {
            return cache[y][x];
        }
        return cache[y][x] = triangle[y][x] + Math.max(dp(y + 1, x), dp(y + 1, x + 1));
    }
}