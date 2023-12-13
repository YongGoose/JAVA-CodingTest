import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static int currentNumber = 1;
    static char[] result = new char[1000001];
    static int resultIndexNum = 0;
    static boolean resultBoolean = true;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int range = Integer.parseInt(st.nextToken());

        int[] targetNums = new int[range];
        for (int i = 0; i < range; i++) {
            st = new StringTokenizer(br.readLine());
            targetNums[i] = Integer.parseInt(st.nextToken());
        }
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < targetNums.length; i++) {
            if (currentNumber <= targetNums[i]) {
                push(targetNums[i], stack);
            } else {
                pop(targetNums[i], stack);
            }
        }
        if (resultBoolean == false) {
            System.out.println("NO");
        } else {
            for (int i = 0; i < resultIndexNum; i++) {
                System.out.println(result[i]);
            }
        }

    }

    static void push(int number, Stack<Integer> stack) {
        while (currentNumber <= number) {
            stack.push(currentNumber);
            currentNumber++;

            result[resultIndexNum] = '+';
            resultIndexNum++;
        }
        stack.pop();
        result[resultIndexNum] = '-';
        resultIndexNum++;
    }


    static void pop(int number, Stack<Integer> stack) {
        int n = stack.pop();
        if (n > number) {
            resultBoolean = false;
        } else {
            result[resultIndexNum] = '-';
            resultIndexNum++;
        }
    }
}
