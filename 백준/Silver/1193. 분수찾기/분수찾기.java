import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int x_range = 10_000_000;
    static int number, number_gap;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= x_range; i++) {
            x -= i;
            if (x <= 0) {
                number = i;
                number_gap = x;
                break;
            }
        }
        int deno = 0; // 분모
        int nume = 0; // 분자
        if (number % 2 == 1) {
            deno = number + number_gap;
            nume = -(number_gap - 1);
            System.out.println(nume + "/" + deno);
        } else {
            deno = -(number_gap - 1);
            nume = number + number_gap;
            System.out.println(nume + "/" + deno);
        }

    }
}