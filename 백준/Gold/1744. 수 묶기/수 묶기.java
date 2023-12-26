import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int range = Integer.parseInt(st.nextToken());
        PriorityQueue<Integer> plusQueue = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minusQueue = new PriorityQueue<>();
        int zero = 0;
        int one = 0;
        for (int i = 0; i < range; i++) {
            st = new StringTokenizer(br.readLine());
            int number = Integer.parseInt(st.nextToken().trim());
            if (number > 1) {
                plusQueue.add(number);
            } else if (number < 0) {
                minusQueue.add(number);
            } else if (number == 0) {
                zero += 1;
            } else {
                one += 1;
            }
        }
        int data1 = 0;
        int data2 = 0;
        int result = 0;
        if (plusQueue.size() % 2 == 1) {
            while (plusQueue.size() > 1) {
                data1 = plusQueue.remove();
                data2 = plusQueue.remove();

                result += data1 * data2;
            }
            result += plusQueue.remove();
        } else {
            while (!plusQueue.isEmpty()) {
                data1 = plusQueue.remove();
                data2 = plusQueue.remove();

                result += data1 * data2;
            }
        }
        if (minusQueue.size() % 2 == 1) {
            while (minusQueue.size() > 1) {
                data1 = minusQueue.remove();
                data2 = minusQueue.remove();

                result += data1 * data2;
            }
        } else {
            while (!(minusQueue.isEmpty())) {
                data1 = minusQueue.remove();
                data2 = minusQueue.remove();

                result += data1 * data2;
            }
        }

        while (zero > 0 && minusQueue.size() > 0) {
            zero--;
            minusQueue.remove();
        }
        if (minusQueue.size() > 0) {
            while (!minusQueue.isEmpty()) {
                result += minusQueue.remove();
            }
        }
        while (one > 0) {
            result++;
            one--;
        }
        System.out.println(result);
    }
}