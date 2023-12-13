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

        /*
        push를 할 때
        -> 배열에 있는 목표 숫자에 다다를때까지 push
        pop을 할 때
        -> 가장 위에 있는 숫자 하나만 pop 한다.
         */
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
        /*
        currentNumber -> 다음에 push할 숫자
        number -> 배열에 있는 목표로 하는 숫자
        currentNumber이 number과 같게 될때까지 push를 해야하므로 조건문을 저렇게 형성함.
         */
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
        /*
        현재 pop 하려는 숫자보다 더 큰 숫자를 pop 하면 안 되기 때문에 조건문 생성
         */
        if (n > number) {
            resultBoolean = false;
        } else {
            result[resultIndexNum] = '-';
            resultIndexNum++;
        }
    }
}

//