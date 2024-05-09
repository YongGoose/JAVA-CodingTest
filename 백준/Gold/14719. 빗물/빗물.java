import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        map = new int[w];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < w; i++) {
            map[i] = Integer.parseInt(st.nextToken());
        }
        if (w < 3) {
            System.out.println("0");
            return;
        }
        System.out.println(rainDrop(h, w));
    }

    static int rainDrop(int h, int w) {
        int result = 0;
        for (int i = 1; i < w - 1; i++) {
            int current = map[i];
            if (current == h) {
                continue;
            }
            int leftMax = 0, rightMax = 0;

            for (int j = 0; j < i; j++) {
                leftMax = Math.max(leftMax, map[j]);
            }
            for (int j = i + 1; j < w; j++) {
                rightMax = Math.max(rightMax, map[j]);
            }
            if (leftMax > current && rightMax > current) {
                result += calculate(leftMax, rightMax, current);
            }
        }
        return result;
    }

    static int calculate(int leftMax, int rightMax, int current) {
        if (leftMax > rightMax) {
            return rightMax - current;
        } else {
            return leftMax - current;
        }
    }
}