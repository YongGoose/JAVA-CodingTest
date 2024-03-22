import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[][] friends;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        friends = new int[n + 1][n + 1];
        for (int i = 1; i < n + 1; i++) {
            Arrays.fill(friends[i], 100_000_000);
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            friends[a][b] = Math.min(friends[a][b], 1);
            friends[b][a] = Math.min(friends[b][a], 1);
        }
        floyd();
        int result = Integer.MAX_VALUE;
        int minPerson = Integer.MAX_VALUE;
        for (int i = 1; i < n + 1; i++) {
            int sum = 0;
            for (int j = 1; j < n + 1; j++) {
                if (i == j) {
                    continue;
                }
                sum += friends[i][j];
            }
            if (result > sum) {
                result = sum;
                minPerson = i;
            }
            if (result == sum) {
                minPerson = Math.min(minPerson, i);
            }
        }
        System.out.println(minPerson);
    }

    static void floyd() {
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                for (int k = 1; k < n + 1; k++) {
                    friends[j][k] = Math.min(friends[j][k], friends[j][i] + friends[i][k]);
                }
            }
        }
    }
}