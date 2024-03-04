import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] lights;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int lightNum = Integer.parseInt(st.nextToken());
        lights = new int[lightNum];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < lightNum; i++) {
            lights[i] = Integer.parseInt(st.nextToken());
        }

        int testCase = Integer.parseInt(br.readLine());
        while (testCase-- > 0) {
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            if (gender == 1) {
                boys(Integer.parseInt(st.nextToken()));
            } else {
                girls(Integer.parseInt(st.nextToken()));
            }
        }
        for (int i = 0; i < lights.length; i++) {
            System.out.print(lights[i] + " ");
            if ((i + 1) % 20 == 0) {
                System.out.println();
            }
        }
    }

    static void boys(int x) {
        for (int i = 0; i < lights.length; i++) {
            if ((i + 1) % x == 0) {
                lights[i] = changeColor(lights[i]);
            }
        }
    }

    static void girls(int x) {
        x = x - 1;
        int left = x - 1;
        int right = x + 1;
        while (isOnBoard(left, right)) {
            if (lights[left] != lights[right]) {
                break;
            }
            left--;
            right++;
        }
        for (int k = left + 1; k < right; k++) {
            lights[k] = changeColor(lights[k]);
        }
    }

    static int changeColor(int x) {
        if (x == 0) {
            return 1;
        }
        return 0;
    }

    static boolean isOnBoard(int first, int second) {
        return first >= 0 && second < lights.length && (lights[first] == lights[second]);
    }
}