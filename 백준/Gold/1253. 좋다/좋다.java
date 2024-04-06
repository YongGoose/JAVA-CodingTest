import java.util.*;
import java.io.*;

public class Main {
    static int[][] array;
    static int cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int testCase = Integer.parseInt(st.nextToken());
        int[] numbers = new int[testCase];
        array = new int[testCase][testCase];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < testCase; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(numbers);
        for (int i = 1; i < testCase; i++) {
            for (int j = 0; j < i; j++) {
                array[j][i] = numbers[i] + numbers[j];
            }
        }
        int result = 0;
        for (int i = 0; i < testCase; i++) {
            if (getResult(array, numbers[i], i)) {
                result++;
            }
        }
        System.out.println(result);
    }

    public static boolean getResult(int[][] array, int number, int idx) {
        int length = array.length;
        for (int i = 0; i < length; i++) {

            if (i == idx) {
                continue;
            }

            if (binarySearch(i, array[i].length - 1, i, number, idx)) {
                return true;
            }
        }
        return false;
    }

    static boolean binarySearch(int left, int right, int idx, int key, int keyIdx) {
        while (left <= right) {
            int mid = (left + right) / 2;

            if (array[idx][mid] > key) {
                right = mid - 1;
            } else if (idx != mid && mid != keyIdx && array[idx][mid] == key) {
                return true;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }
}

