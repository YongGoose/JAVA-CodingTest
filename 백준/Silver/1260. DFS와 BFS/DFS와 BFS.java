import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer>[] arrayLists;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        arrayLists = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        for (int i = 1; i < n + 1; i++) {
            arrayLists[i] = new ArrayList<>();
            visited[i] = false;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int last = Integer.parseInt(st.nextToken());

            arrayLists[first].add(last);
            arrayLists[last].add(first);
        }
        /*
        각 노드별 숫자를 정렬하기 위해 for 반복문을 통해 정렬함
         */
        for (int i = 1; i < n + 1; i++) {
            Collections.sort(arrayLists[i]);
        }
        DFS(v);
        System.out.println();
        for (int i = 1; i < n + 1; i++) {
            visited[i] = false;
        }
        BFS(v);
        System.out.println();
    }

    static void DFS(int i) {
        System.out.print(i + " ");
        visited[i] = true;

        for (int number: arrayLists[i]) {
            if (!visited[number]) {
                DFS(number);
            }
        }
    }

    static void BFS(int i) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(i);
        visited[i] = true;

        while (!queue.isEmpty()) {
            int number = queue.poll();
            System.out.print(number + " ");
            for (int num: arrayLists[number]) {
                if (!visited[num]) {
                    visited[num] = true;
                    queue.add(num);
                }
            }
        }
    }
}