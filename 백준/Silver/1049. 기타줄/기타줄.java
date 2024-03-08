import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static PriorityQueue<Integer> pair = new PriorityQueue<>();
    static PriorityQueue<Integer> pacakge = new PriorityQueue<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int cnt = 0;
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            pacakge.offer(Integer.parseInt(st.nextToken()));
            pair.offer(Integer.parseInt(st.nextToken()));
            cnt++;
        }
        int minPackege = pacakge.peek();
        int minPair = pair.peek();
        System.out.println(guitar(n, minPackege, minPair));
    }

    static int guitar(int n, int minPackage, int minPair) {
        if (n >= 6) {
            if (minPackage < (minPair * 6)) {
                if (minPackage > minPair * (n % 6)) {
                    return n / 6 * minPackage + n % 6 * minPair;

                }
                return (n / 6 + 1) * minPackage;
            }
            return minPair * n;
        }
        return Math.min(minPackage, (minPair * n));
    }
}