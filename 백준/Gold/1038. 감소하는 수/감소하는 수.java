import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static List<Long> numbers = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        for (int i = 0; i < 10; i++) {
            dfs(i, 1);
        }
        Collections.sort(numbers);

        if (n < 10) {
            System.out.println(n);
            return;
        }
        if (n > 1022) {
            System.out.println("-1");
            return;
        } else {
            System.out.println(numbers.get(n));
        }
    }

    static void dfs(long num, int idx) {
        if (idx > 10) {
            return;
        }
        numbers.add(num);
        for (int i = 0; i < num % 10; i++) {
            dfs((num * 10) + i, idx + 1);
        }
    }
}