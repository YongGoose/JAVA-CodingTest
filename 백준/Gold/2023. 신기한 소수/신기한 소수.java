import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int range;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        range = Integer.parseInt(st.nextToken());
        DFS(2, 1);
        DFS(3, 1);
        DFS(5, 1);
        DFS(7, 1);
    }

    static void DFS(int number, int depth) {
        if (depth == range) {
            if (isPrimeNumber(number)) {
                System.out.println(number);
            }
            return;
        }
        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) {
                continue;
            } else {
                if (isPrimeNumber(number * 10 + i)) {
                    DFS(number * 10 + i, depth + 1);
                }
            }
        }
    }

    static boolean isPrimeNumber(int i) {
        for (int j = 3; j <= i / 2; j++) {
            if (i % j == 0) {
                return false;
            }
        }
        return true;
    }
}