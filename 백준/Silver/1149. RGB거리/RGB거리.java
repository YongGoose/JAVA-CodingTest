import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[][] housePaint;
    static int[][] cache;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        housePaint = new int[n][3];
        cache = new int[n][3];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                housePaint[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp();
        int minValue = Arrays.stream(cache[n - 1]).min().getAsInt();
        System.out.println(minValue);
    }
    /*
    dp를 풀 때 모든 경우의 수를 구해야 한다면 출발지와 종착점의 개수를 구한다.
    우선 이 문제에서는 집의 종류가 총 3가지이므로 3가지의 시작점과 종료지점이 있다.
    그러므로 for 반복문을 통해 3가지의 경우의 수를 모두 구한 뒤, 마지막에 min 값을 구하도록 구현하였다.
     */
    static void dp() {
        init();
        for (int i = 1; i < n; i++) {
            cache[i][0] = Math.min(cache[i - 1][1], cache[i - 1][2]) + housePaint[i][0];
            cache[i][1] = Math.min(cache[i - 1][0], cache[i - 1][2]) + housePaint[i][1];
            cache[i][2] = Math.min(cache[i - 1][0], cache[i - 1][1]) + housePaint[i][2];
        }
    }

    static void init() {
        cache[0][0] = housePaint[0][0];
        cache[0][1] = housePaint[0][1];
        cache[0][2] = housePaint[0][2];
    }
}