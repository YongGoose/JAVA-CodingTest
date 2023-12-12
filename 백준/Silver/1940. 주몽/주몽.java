import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());

        int[] numbers = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        numbers = Arrays.stream(numbers).sorted().toArray();
        int count = 0;
        int sum = 0;

        int startPoint = 0;
        int endPoint = n-1;
        while (startPoint < endPoint) {
            sum = numbers[startPoint] + numbers[endPoint];

            if (sum < m) {
                startPoint++;
            } else if (sum > m) {
                endPoint--;
            } else {
                count++;
                endPoint--;
            }
        }
        System.out.println(count);
    }
}
