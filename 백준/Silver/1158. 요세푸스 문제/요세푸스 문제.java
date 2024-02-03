import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        Queue<Integer> queue = new LinkedList<>();
        Queue<Integer> result = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }
        while (!queue.isEmpty()) {
            for (int i = 0; i < k - 1; i++) {
                int removeNumber = queue.remove();
                queue.add(removeNumber);
            }
            result.add(queue.remove());
        }
        System.out.print("<");
        for (int i = 0; i < n; i++) {
            if (result.size() == 1) {
                System.out.print(result.remove());
            } else {
                System.out.print(result.remove() + ", ");
            }
        }
        System.out.print(">");
    }
}