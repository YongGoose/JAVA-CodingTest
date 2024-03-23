import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int testCase = Integer.parseInt(st.nextToken());
        while (testCase-- > 0) {
            int nums = Integer.parseInt(br.readLine());

            String input = br.readLine();
            String answerInput = br.readLine();
            int wb = 0;
            int bw = 0;
            for (int i = 0; i < nums; i++) {
                if (input.charAt(i) != answerInput.charAt(i)) {
                    if (input.charAt(i) == 'W') {
                        wb++;
                    } else {
                        bw++;
                    }
                }
            }
            System.out.println(wb + bw - Math.min(wb, bw));
            
        }
    }


}