import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken()); // 조카의 수
        int n = Integer.parseInt(st.nextToken()); // 막대 과자의 수
        int[] snacks = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            snacks[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(snacks);
//        if (m <= n) {
//            System.out.println(snacks[n - m]);
//            return;
//        }
        System.out.println(binarySearch(snacks, m, 1, snacks[n - 1]));

    }

    public static int binarySearch(int[] array, int m, int left, int right) {
        int result = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            int cnt = 0;
            for (int number : array) {
                cnt += number / mid;
            }
            if (cnt < m) {
                right = mid - 1;
            } else {
                result = mid;
                left = mid + 1;
            }
        }
        return result;
    }
}