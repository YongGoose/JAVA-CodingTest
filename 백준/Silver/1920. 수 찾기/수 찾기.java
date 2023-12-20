import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] array;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(array);
        st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] missionArray = new int[m];
        for (int i = 0; i < m; i++) {
            missionArray[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < m; i++) {
            binarySearch(missionArray[i], 0, array.length -1);
        }
    }

    static void binarySearch(int number, int startIndex, int endIndex) {
        boolean find = false;
        while (startIndex <= endIndex) {
            int mid = (startIndex + endIndex) / 2;
            if (array[mid] == number) {
                find = true;
                break;
            } else if (array[mid] > number) {
                endIndex = mid - 1;
            } else {
                startIndex = mid + 1;
            }
        }
        if (find) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}