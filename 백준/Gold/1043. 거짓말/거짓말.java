import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] parent;
    static int[] knowledgeParent;
    static ArrayList<Integer>[] arrayLists;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        parent = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            parent[i] = i;
        }
        arrayLists = new ArrayList[m];

        for (int i = 0; i < m; i++) {
            arrayLists[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());
        int know = Integer.parseInt(st.nextToken());
        knowledgeParent = new int[know];
        for (int i = 0; i < know; i++) {
            knowledgeParent[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int partyNumber = Integer.parseInt(st.nextToken());
            if (partyNumber > 1) {
                int number = Integer.parseInt(st.nextToken());
                arrayLists[i].add(number);
                for (int j = 1; j < partyNumber; j++) {
                    int nums = Integer.parseInt(st.nextToken());
                    arrayLists[i].add(nums);
                    union(number, nums);
                }
            } else {
                int number = Integer.parseInt(st.nextToken());
                arrayLists[i].add(number);
            }
        }
        int result = 0;
        for (int i = 0; i < m; i++) {
            boolean isPossible = false;

            for (int j = 0; j < knowledgeParent.length; j++) {
                if (find(arrayLists[i].get(0)) == find(knowledgeParent[j])) {
                    isPossible = true;
                    break;
                }
            }
            if (isPossible) {
                continue;
            } else {
                result++;
            }
        }
        System.out.println(result);
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x <= y) {
            parent[y] = x;
        } else {
            parent[x] = y;
        }
    }

    static int find(int number) {
        if (parent[number] == number) {
            return number;
        }
        return find(parent[number]);
    }
}