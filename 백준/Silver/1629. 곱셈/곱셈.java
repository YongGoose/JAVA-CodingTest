import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int result = 1;
    static long a, b, c;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        System.out.println(getResult(a, b));

    }


    static long getResult(long a, long b) {
        if (b == 1) {
            return a % c;
        }
        long result = getResult(a, b / 2);
        if (b % 2 == 1) {
            return (result * result % c) * (a % c) % c;
        }
        return (result * result) % c;
    }
}