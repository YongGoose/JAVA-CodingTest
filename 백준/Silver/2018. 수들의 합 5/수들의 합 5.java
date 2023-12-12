import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int number = Integer.parseInt(st.nextToken());
        int count = 1;
        int sum = 1;

        int startPoint = 1;
        int endPoint = 1;

        while (endPoint != number) {
            if (sum == number) {
                count++;
                endPoint++;
                sum += endPoint;
            } else if (sum < number) {
                endPoint++;
                sum += endPoint;
            } else {
                sum -= startPoint;
                startPoint++;
            }
        }
        System.out.println(count);
    }
}
