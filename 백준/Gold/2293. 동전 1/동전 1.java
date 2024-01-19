import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.StringTokenizer;

public class Main {
    static int[] coin;
    static int n, k;
    static int[] coinValue;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        coin = new int[k + 1];
        coinValue = new int[n];

        for (int i = 0; i <n; i++) {
            st = new StringTokenizer(br.readLine());
            coinValue[i] = Integer.parseInt(st.nextToken());
        }
        //0을 만드는 과정은 1가지다.(아무것도 사용하지 않는 것)
        coin[0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = coinValue[i]; j <= k; j++) {
                coin[j] = coin[j] + coin[j - coinValue[i]];
            }
        }
        // coin[j] = coin[j] + coin[j - coinValue[i]]라는 식이 중요함.
        System.out.println(coin[k]);
    }
}
