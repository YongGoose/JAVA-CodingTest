import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[] nArray = new int[31];
        nArray[0] = 1;
        nArray[1] = 0;
        nArray[2] = 3;

        for (int i = 4; i <= n; i+= 2) {
            nArray[i] = nArray[i - 2] * 3;
            for (int j = i - 4; j >= 0 ; j-= 2) {
                nArray[i] = nArray[i] + (nArray[j] * 2);
            }
        }
        System.out.println(nArray[n]);
        br.close();
    }
}