import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static boolean[] ball;
    static boolean[] answerBall;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int testCase = Integer.parseInt(st.nextToken());
        while (testCase-- > 0) {
            int nums = Integer.parseInt(br.readLine());
            ball = new boolean[nums];
            answerBall = new boolean[nums];

            String input = br.readLine();
            for (int i = 0; i < nums; i++) {
                ball[i] = isBlack(input.charAt(i));
            }
            String answerInput = br.readLine();
            for (int i = 0; i < nums; i++) {
                answerBall[i] = isBlack(answerInput.charAt(i));
            }
            System.out.println(calculateBalls());
        }
    }

    static boolean isBlack(char input) {
        return input == 'B';
    }

    static int calculateBalls() {
        int cnt = 0;
        ArrayList<Node> hasToMove = new ArrayList<>();

        for (int i = 0; i < ball.length; i++) {
            if (ball[i] != answerBall[i]) {
                boolean removed = false;
                for (int num = 0; num < hasToMove.size(); num++) {
                    Node node = hasToMove.get(num);
                    if (node.value != ball[i]) {
                        removed = true;
                        hasToMove.remove(node);
                        ball[i] = !ball[i];
                        cnt++;
                    }
                }
                if (!removed) {
                    hasToMove.add(new Node(ball[i]));
                }
            }
            
        }

        cnt += hasToMove.size();
        return cnt;
    }

    static class Node {
        boolean value;

        public Node(boolean value) {
            this.value = value;
        }
    }
}