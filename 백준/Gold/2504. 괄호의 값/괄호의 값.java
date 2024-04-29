import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String input = st.nextToken();
        Stack<Character> stack = new Stack<>();
        int result = 0, seRes = 1;
        for (int i = 0; i < input.length(); i++) {
            char in = input.charAt(i);
            switch (in) {
                case '(':
                    seRes *= 2;
                    stack.push(in);
                    break;
                case '[':
                    seRes *= 3;
                    stack.push(in);
                    break;
                case ')':
                    if (!calculate(in, stack)) {
                        System.out.println(0);
                        return;
                    } else if (i > 0 && input.charAt(i - 1) == '(') {
                        result += seRes;
                    }
                    stack.pop();
                    seRes /= 2;
                    break;
                case ']':
                    if (!calculate(in, stack)) {
                        System.out.println(0);
                        return;
                    } else if (i > 0 && input.charAt(i - 1) == '[') {
                        result += seRes;
                    }
                    stack.pop();
                    seRes /= 3;
                    break;
            }
        }
        if (!stack.isEmpty()) {
            result = 0;
        }
        System.out.println(result);
    }

    private static boolean calculate(char in, Stack<Character> stack) {
        if (stack.isEmpty()) return false;
        char out = stack.peek();
        if (in == ')') {
            return out == '(';
        }
        return out == '[';
    }
}
