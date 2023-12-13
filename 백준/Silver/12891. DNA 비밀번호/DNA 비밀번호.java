import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] checkArray = new int[4];
    static int count = 0;
    static int checkSecret;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int s = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        char[] charArray = new char[s];
        charArray = br.readLine().toCharArray();

        int[] answerArray = new int[4];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            answerArray[i] = Integer.parseInt(st.nextToken());
        }
        check(p, charArray);
        if (result(answerArray)) {
            count++;
        }

        for (int i = p; i < s; i++) {
            int j = i - p;
            add(charArray[i]);
            remove(charArray[j]);
            if (result(answerArray)) {
                count++;
            }
        }
        System.out.println(count);
        br.close();
    }

    /*
    정답 확인 용도
     */
    public static boolean result(int[] answerArray) {
        checkSecret = 0;
        for (int i = 0; i < 4; i++) {
            if (checkArray[i] >= answerArray[i]) {
                checkSecret++;
            }
        }
        if (checkSecret == 4) {
            return true;
        } else {
            return false;
        }
    }

    /*
    몇 개의 DNA 숫자를 가지고 있는지 체크하는 용도
     */
    public static void check(int range, char[] chars) {
        for (int i = 0; i < range; i++) {
            char character = chars[i];
            switch (character) {
                case 'A':
                    checkArray[0]++;
                    break;
                case 'C':
                    checkArray[1]++;
                    break;
                case 'G':
                    checkArray[2]++;
                    break;
                case 'T':
                    checkArray[3]++;
                    break;
            }
        }
    }

    /*
    숫자를 더했을 때 checkArray를 변경하는 용도
     */
    public static void add(char character) {
        switch (character) {
            case 'A':
                checkArray[0]++;
                break;
            case 'C':
                checkArray[1]++;
                break;
            case 'G':
                checkArray[2]++;
                break;
            case 'T':
                checkArray[3]++;
                break;
        }
    }

    /*
    숫자를 제거했을 때 checkArray를 변경하는 용도
     */
    public static void remove(char character) {
        switch (character) {
            case 'A':
                checkArray[0]--;
                break;
            case 'C':
                checkArray[1]--;
                break;
            case 'G':
                checkArray[2]--;
                break;
            case 'T':
                checkArray[3]--;
                break;
        }
    }
}
