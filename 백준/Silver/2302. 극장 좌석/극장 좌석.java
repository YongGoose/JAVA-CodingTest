import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    static int[] dp = new int[41];
    static int startNum, maxNum, count;
    static ArrayList<Integer> possibleNums = new ArrayList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); // 좌석의 개수
        int m = Integer.parseInt(br.readLine()); // 고정석(vip)의 개수

        startNum = 1;
        for (int i = 0; i < m; i++) {
            int vipSeat = Integer.parseInt(br.readLine());
            if (vipSeat - startNum == 0) { // vip
                possibleNums.add(1);
                startNum = vipSeat + 1;
                continue;
            }
            possibleNums.add(vipSeat - startNum); // 전체에서 vip좌석까지의 구간을 구해 list에 더하는 식
            startNum = vipSeat + 1; // vip 좌석은 포함하면 안되므로 + 1을 해준다.
        }
        if (startNum - 1 != n) {
            possibleNums.add(n - startNum + 1); // 마지막 좌석을 포함해야 하므로 1을 더해준다.
        }

        for (int seatNum : possibleNums) {
            if (maxNum < seatNum) {
                maxNum = seatNum;
            }
        }
        dp[1] = 1;
        dp[2] = 2;
        if (maxNum >= 3) {
            for (int i = 3; i <= maxNum; i++) {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
        }
        count = 1;
        for (int seatNum : possibleNums) {
            count *= dp[seatNum];
        }
        System.out.println(count);
    }
}