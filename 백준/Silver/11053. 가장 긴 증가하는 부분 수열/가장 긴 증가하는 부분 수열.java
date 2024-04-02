import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int arraySize = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] array = new int[arraySize];
        for (int i = 0; i < arraySize; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        int[] resultArray = new int[arraySize + 1];
        int len = 0;
        for (int i = 0; i < arraySize; i++) {
            if (array[i] > resultArray[len]) {
                len++;
                resultArray[len] = array[i];
            } else {
                int idx = binarySearch(0, len, resultArray, array[i]);
                resultArray[idx] = array[i];
            }
        }
        System.out.println(len);

    }

    static int binarySearch(int left, int right, int[] array, int key) {
        while (left < right) {
            int mid = (left + right) / 2;
            if (array[mid] < key) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return right;
    }
}