import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int atoz = 'z' - 'a' + 1;
    static int cnt;
    static int minValue;
    static int maxValue;
    static int[][] words = new int[200_000][atoz];
    static int[] result;
    static ArrayList<Integer> lengths = new ArrayList<>();
    static int[] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String input = br.readLine();
            if (input.equals("-")) {
                break;
            }
            int length = input.length();
            lengths.add(length);
            for (int i = 0; i < length; i++) {
                words[cnt][input.charAt(i) - 'A']++;
            }
            cnt++;
        }
        StringBuilder sb = new StringBuilder();
        while (true) {
            String input = br.readLine();
            if (input.equals("#")) {
                break;
            }
            board = new int[atoz];
            int length = input.length();
            for (int i = 0; i < length; i++) {
                board[input.charAt(i) - 'A']++;
            }
            result = new int[atoz];
            minValue = 20_001;
            maxValue = 0;
            for (int i = 0; i < cnt; i++) {
                if (!isValid(i)) {
                    continue;
                }
                for (int j = 0; j < atoz; j++) {
                    // 3X3 보드보다 특정 문자가 많이 들어간 단어는 제외하기 때문에 단어를 기준으로 계산해도 된다.
                    if (words[i][j] != 0) {
                        result[j]++;
                    }
                }
            }
            checkMinValue();
            checkMaxValue();
            for (int j = 0; j < atoz; j++) {
                if (board[j] != 0 && result[j] == minValue) {
                    sb.append((char) ('A' + j));
                }
            }
            sb.append(' ').append(minValue).append(' ');
            for (int j = 0; j < atoz; j++) {
                if (board[j] != 0 && result[j] == maxValue) {
                    sb.append((char) ('A' + j));
                }
            }
            sb.append(' ').append(maxValue).append("\n");
        }

        System.out.println(sb);
    }

    static boolean isValid(int i) {
        for (int j = 0; j < atoz; j++) {
            if (words[i][j] > board[j]) {
                return false;
            }
        }
        return true;
    }

    static void checkMinValue() {
        for (int i = 0; i < atoz; i++) {
            if (board[i] == 0) {
                continue;
            }
            if (minValue > result[i]) {
                minValue = result[i];
            }
        }
    }

    static void checkMaxValue() {
        for (int i = 0; i < atoz; i++) {
            if (board[i] == 0) {
                continue;
            }
            if (maxValue < result[i]) {
                maxValue = result[i];
            }
        }
    }
}