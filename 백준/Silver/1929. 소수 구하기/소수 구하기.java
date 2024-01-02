import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int first = Integer.parseInt(st.nextToken());
        int last = Integer.parseInt(st.nextToken());

        int[] array = new int[last + 1];
        for (int i = 2; i <= last; i++) {
            array[i] = i;
        }
        for (int i = 2; i <= Math.sqrt(last); i++) {
            if (array[i] == 0) {
                continue;
            }
            for (int j = i + i; j <= last; j = j + i) {
                if (array[j] != 0) {
                    array[j] = 0;
                }
            }
        }
        for (int i = first; i <= last; i++) {
            if (array[i] != 0) {
                System.out.println(array[i]);
            }
        }
    }
}