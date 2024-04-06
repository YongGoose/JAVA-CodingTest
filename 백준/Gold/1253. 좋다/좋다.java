import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int testCase = Integer.parseInt(st.nextToken());
        int[] numbers = new int[testCase];
        int[][] array = new int[testCase][testCase];
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
            for (int j = i; j < length; j++) {
                if (number == array[i][j] && !(i == j)) {
                    if (idx == i || idx == j) {
                        continue;
                    }
                    return true;
                }
            }

        }
        return false;
    }

}