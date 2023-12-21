import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int range = Integer.parseInt(st.nextToken());
        int blueray = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] lessons = new int[range];
        int startIndex = 0;
        int endIndex = 0;
        for (int i = 0; i < range; i++) {
            lessons[i] = Integer.parseInt(st.nextToken());
            if (startIndex < lessons[i]) {
                startIndex = lessons[i];
            }
            endIndex += lessons[i];
        }
        while (startIndex <= endIndex) {
            int mid = (startIndex + endIndex) / 2;
            int count = 0;
            int sum = 0;
            for (int i = 0; i < range; i++) {
                if (sum + lessons[i] > mid) {
                    sum = 0;
                    count++;
                }
                sum += lessons[i];
            }
            if (sum != 0) {
                count++;
            }
            if (count > blueray) {
                startIndex = mid + 1;
            } else {
                endIndex = mid - 1;
            }
        }
        System.out.println(startIndex);
    }
}