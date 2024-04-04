import java.io.*;
import java.util.*;

public class Main {
    static int[] array;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int number = Integer.parseInt(st.nextToken());

        array = new int[number + 1];
        System.out.println(dp(number, array));
    }

    static int dp(int number, int[] array) {
        for (int i = 2; i <= number; i++) {
            array[i] = array[i - 1] + 1;
            if (i % 2 == 0) {
                array[i] = Math.min(array[i], array[i / 2] + 1);
            }
            if (i % 3 == 0) {
                array[i] = Math.min(array[i], array[i / 3] + 1);
            }
        }
        return array[number];
    }
}