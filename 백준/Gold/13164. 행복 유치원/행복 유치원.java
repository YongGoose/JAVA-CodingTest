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
        int k = Integer.parseInt(st.nextToken());

        int[] students = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            students[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(greedy(students, k));
    }

    static int greedy(int[] students, int k) {
        int result = 0;

        int[] diff = new int[students.length - 1];

        for (int i = 0; i < students.length - 1; i++) {
            diff[i] = students[i + 1] - students[i];
        }
        Arrays.sort(diff);

        for (int i = 0; i < diff.length - k + 1; i++) {
            result += diff[i];
        }
        return result;
    }
}