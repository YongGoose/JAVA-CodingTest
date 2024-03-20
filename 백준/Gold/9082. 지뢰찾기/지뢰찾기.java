//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.StringTokenizer;
//
//public class Main {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        char[] bombs;
//        int[] numbers;
//
//        int testCase = Integer.parseInt(st.nextToken());
//        while (testCase-- > 0) {
//            int n = Integer.parseInt(br.readLine());
//            numbers = new int[n];
//            bombs = new char[n];
//
//            String input = br.readLine();
//            for (int i = 0; i < n; i++) {
//                numbers[i] = input.charAt(i) - '0';
//            }
//
//            String bombInput = br.readLine();
//            for (int i = 0; i < n; i++) {
//                bombs[i] = bombInput.charAt(i);
//            }
//
//        }
//    }
//}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] numbers;

        int testCase = Integer.parseInt(st.nextToken());
        while (testCase-- > 0) {
            int n = Integer.parseInt(br.readLine());
            numbers = new int[n];

            String input = br.readLine();
            for (int i = 0; i < n; i++) {
                numbers[i] = input.charAt(i) - '0';
            }
            br.readLine();

            int result = 0;
            if (numbers[0] != 0) {
                result++;
            }
            if (numbers[n - 1] != 0) {
                result++;
            }
            for (int i = 0; i < n; i++) {
                result += numbers[i];
            }
            System.out.println(result / 3);
        }
    }
}