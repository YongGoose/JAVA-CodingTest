import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    private static HashMap<Long, Long> map = new HashMap<>();
    private static long p = 0L;
    private static long q = 0L;
    private static long x = 0L;
    private static long y = 0L;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split(" ");
        long n = Long.parseLong(input[0]);
        p = Long.parseLong(input[1]);
        q = Long.parseLong(input[2]);
        x = Long.parseLong(input[3]);
        y = Long.parseLong(input[4]);
        map.put(0L, 1L);
        System.out.println(sequence(n));
    }

    private static long sequence(long n) {
        if (n <= 0L) return 1;
        if (map.containsKey(n)) return map.get(n);
        long result = sequence(n / p - x) + sequence(n / q - y);
        map.put(n, result);
        return result;
    }
}