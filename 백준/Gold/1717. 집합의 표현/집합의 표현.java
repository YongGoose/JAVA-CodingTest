import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] parents = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            parents[i] = i;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());
            int first = Integer.parseInt(st.nextToken());
            int last = Integer.parseInt(st.nextToken());

            if (type == 0) {
                union(parents, first, last);
            } else {
                int x = findParents(parents, first);
                int y = findParents(parents, last);
                parents[first] = x;
                parents[last] = y;
                if (x == y) {
                    sb.append("YES").append("\n");
                } else {
                    sb.append("NO").append("\n");
                }
            }
        }
        System.out.println(sb);
    }

    static void union(int[] parents, int first, int last) {
        int x = findParents(parents, first);
        int y = findParents(parents, last);

        if (x <= y) {
            parents[y] = x;
        } else {
            parents[x] = y;
        }
    }

    static int findParents(int[] parents, int number) {
        if (parents[number] == number) {
            return parents[number];
        }
        return findParents(parents, parents[number]);
    }
}