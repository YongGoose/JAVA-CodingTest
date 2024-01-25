import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    //graph 초기화 작업 필수
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int count;
    static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 정점
        int m = Integer.parseInt(st.nextToken()); // 간선
        int r = Integer.parseInt(st.nextToken()); // 시작 노드

        graph = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        result = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
            visited[i] = false;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());

            graph[first].add(second);
            graph[second].add(first);
        }

        for (int i = 1; i <= n; i++) {
            Collections.sort(graph[i]);
        }
        count++;
        DPS(r);
        for (int i = 1; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

    /*
    DPS는 재귀함수를 통해 해결한다.
    방문 여부를 확인한 다음, 방문하지 않았으면 재귀 함수를 통해 그 노드를 탐색한다.
     */
    static void DPS(int node) {
        visited[node] = true;
        result[node] = count;

        int length = graph[node].size();
        for (int i = 0; i < length; i++) {
            if (!visited[graph[node].get(i)]) {
                count++;
                DPS(graph[node].get(i));
            }
        }
    }
}