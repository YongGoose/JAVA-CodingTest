import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[] array = new int[n + 1];
        array[0] = 1;
        array[1] = 3;

        for (int i = 2; i < n + 1; i++) {
            array[i] = (array[i - 1] * 2 + array[i - 2]) % 9901;
        }
        System.out.println(array[n]);
    }
}