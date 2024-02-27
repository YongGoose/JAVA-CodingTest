import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static Map<Long, Long> hashMap = new HashMap<>();
    static long n, p, q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Long.parseLong(st.nextToken());
        p = Long.parseLong(st.nextToken());
        q = Long.parseLong(st.nextToken());
        hashMap.put(0L, 1L);
        System.out.println(dp(n));
    }

    static long dp(long x) {
        if (hashMap.containsKey(x)) {
            return hashMap.get(x);
        }
        long value = dp(x / p) + dp(x / q);
        hashMap.put(x, value);
        return value;
    }
}