import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long number = Long.parseLong(st.nextToken());
        long result = number;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                result = result - result / i;
                while (number % i == 0) {
                    number /= i;
                }
            }
        }
        if (number > 1) {
            result = result - result / number;
        }
        System.out.println(result);
    }
}