import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    /**
     *
     * 지민이는 세계에서 가장 유명한 사람이 누구인지 궁금해졌다. 가장 유명한 사람을 구하는 방법은 각사람의 2-친구를 구하면 된다
     어떤 사람 A가 또다른 사람 B의 2-친구가 되기 위해선 두 사람이 친구이거나 A와 친구이고 B와 친구인 C가 존재해야 한다.
     *여기서 가장 유명한 사람은 2- 친구의 수가 가장 많은 사람이다 가장 유명한 사람의 20친구의 수를 출력하는 프로그램을 작성하시오
     * */


    static final int INF = 100000000;

    static int[][] cost = new int[51][51];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for (int i = 1; i <= N ; i++) {
            char[] str = br.readLine().toCharArray();
            for (int j = 1; j <= N ; j++) {
                if(i == j) continue;
                cost[i][j] = str[j - 1] == 'Y' ? 1 : INF;
            }
        }



        for(int i = 1; i <= N;i++){
            for(int j = 1;j<=N;j++){
                for(int k = 1;k<=N;k++){
                    if(j == k) continue;
                    cost[j][k] = Math.min(cost[j][k],cost[j][i]+cost[i][k]);
                }
            }
        }


        int max = 0;

        for (int i = 1; i <= N ; i++) {
            int cnt = 0;
            for (int j = 1; j <= N ; j++) {
                if(cost[i][j] == 2 || cost[i][j] == 1){
                    cnt++;
                }
            }
            max = Math.max(max,cnt);
        }

        System.out.println(max);
    }
}