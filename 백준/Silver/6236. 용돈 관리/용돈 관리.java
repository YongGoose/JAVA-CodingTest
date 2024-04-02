import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] array;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int max = 0;
        array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, array[i]);
        }

        System.out.println(binarySearch(max, 10_000 * 100_000, m));
    }

    static int binarySearch(int left, int right, int m) {
        int result = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (isValid(mid, m)) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return result;
    }

    static boolean isValid(int money, int m) {
        int extraMoney = money;
        int count = 1;

        for (int mo : array) {
            if (money < mo) {
                return false;
            }
            if (extraMoney < mo) {
                extraMoney = money;
                count++;
            }
            extraMoney -= mo;
        }
        return m >= count;
    }
}