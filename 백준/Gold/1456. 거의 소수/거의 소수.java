import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        long first = sc.nextLong();
        long last = sc.nextLong();

        long[] array = new long[10000001];
        for (int i = 2; i < array.length; i++) {
            array[i] = i;
        }
        for (int i = 2; i < Math.sqrt(array.length); i++) {
            if (array[i] == 0) {
                continue;
            }
            for (int j = i + i; j < array.length; j += i) {
                array[j] = 0;
            }
        }
        int count = 0;
        for (int i = 2; i < 10000001; i++) {
            if (array[i] != 0) {
                long temp = array[i];
                while ((double) array[i] <= (double) last / (double) temp) {
                    if ((double) array[i] >= (double) first / (double) temp) {
                        count++;
                    }
                    temp = temp * array[i];
                }
            }
        }
        System.out.println(count);
    }
}