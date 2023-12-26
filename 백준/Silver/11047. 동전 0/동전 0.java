import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int range = Integer.parseInt(st.nextToken());
        int number = Integer.parseInt(st.nextToken());

        int[] coins = new int[range];
        for (int i = 0; i < range; i++) {
            st = new StringTokenizer(br.readLine());
            coins[i] = Integer.parseInt(st.nextToken());
        }
        int count = 0;
        for (int i = range - 1; i >= 0; i--) {
            if (number >= coins[i]) {
                count += number / coins[i];
                number = number % coins[i];
                if (checkNumberIsZero(number)) {
                    break;
                }
            }
        }

        System.out.println(count);
    }

    static boolean checkNumberIsZero(int number) {
        return number == 0;
    }
}