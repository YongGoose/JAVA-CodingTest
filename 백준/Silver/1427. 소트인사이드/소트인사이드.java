import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] array;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String numbers = br.readLine();
        array = new int[numbers.length()];
        int[] resultArray = new int[numbers.length()];

        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(String.valueOf(numbers.charAt(i)));
        }
        for (int i = 0; i < array.length; i++) {
            int min = 0;
            int index = 0;
            for (int j = i; j < array.length; j++) {
                if (min < array[j]) {
                    min = array[j];
                    index = j;
                }
            }
            swap(i, index);
            resultArray[i] = min;
        }
        for (int i = 0; i < array.length; i++) {
            System.out.print(resultArray[i]);
        }
    }

    static void swap(int x, int y) {
        int number;
        number = array[x];
        array[x] = array[y];
        array[y] = number;
    }
}