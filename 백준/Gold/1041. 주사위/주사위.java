import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    
    static int[] dice = new int[6];
    static long[] total = new long[3];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        total[0] = 4L;
        total[1] = 8L * (n - 2) + 4;
        total[2] = 5L * (n - 2) * (n - 2) + 4L * (n - 2);

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 6; i++) {
            dice[i] = Integer.parseInt(st.nextToken());
        }

        long result = 0;
        if (n == 1) {
            Arrays.sort(dice);
            for (int i = 0; i < 5; i++) {
                result += dice[i];
            }
            System.out.println(result);
            return;
        }

        long minAF = Math.min(dice[0], dice[5]);
        long minBE = Math.min(dice[1], dice[4]);
        long minCD = Math.min(dice[2], dice[3]);

        long oneSide = Math.min(minAF, Math.min(minBE, minCD));
        long twoSide = Math.min(minAF + minBE, Math.min(minAF + minCD, minBE + minCD));
        long threeSide = minAF + minBE + minCD;

        result += oneSide * total[2] + twoSide * total[1] + threeSide * total[0];
        System.out.println(result);
    }
}