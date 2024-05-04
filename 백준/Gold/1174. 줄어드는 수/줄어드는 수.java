import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static List<Long> integers = new ArrayList<>();
    static int[] digit = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        dfs(0, 0);
        Collections.sort(integers);
        try {
            sb.append(integers.get(n - 1));
        } catch (IndexOutOfBoundsException e) {
            sb.append(-1);
        }
        System.out.println(sb);
        br.close();
    }

    static void dfs(long number, int x) {
        if (!integers.contains(number)) {
            integers.add(number);
        }
        if (x >= 10) {
            return;
        }
        dfs(number, x + 1);
        dfs(number * 10 + digit[x], x + 1);
    }
}