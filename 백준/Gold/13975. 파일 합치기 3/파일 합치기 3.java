import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int testCase = Integer.parseInt(st.nextToken());
        while (testCase-- > 0) {
            PriorityQueue<Long> pq = new PriorityQueue<>();
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < k; i++) {
                pq.add(Long.parseLong(st.nextToken()));
            }
            System.out.println(greedy(pq));
        }
    }

    static long greedy(PriorityQueue<Long> pq) {
        long result = 0;

        while (pq.size() > 1) {
            long num = pq.poll() + pq.poll();
            result += (num);
            pq.add(num);
        }
        return result;
    }
}