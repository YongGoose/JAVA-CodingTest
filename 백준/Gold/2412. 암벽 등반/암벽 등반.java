//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.*;
//
//public class Main {
//    static ArrayList<Integer>[] nodes;
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        int n = Integer.parseInt(st.nextToken());
//        int t = Integer.parseInt(st.nextToken());
//
//        nodes = new ArrayList[200_001];
//        for (int i = 0; i < 200_001; i++) {
//            nodes[i] = new ArrayList<>();
//        }
//
//        for (int i = 0; i < n; i++) {
//            st = new StringTokenizer(br.readLine());
//            int x = Integer.parseInt(st.nextToken());
//            int y = Integer.parseInt(st.nextToken());
//
//            nodes[y].add(x);
//        }
//        for (int i = 0; i < 200_001; i++) {
//            Collections.sort(nodes[i]);
//        }
//        System.out.println(bfs(t));
//    }
//
//    static int bfs(int t) {
//        Queue<Node> queue = new LinkedList<>();
//        queue.add(new Node(0, 0));
//
//        int cnt = 0;
//        while (!queue.isEmpty()) {
//
//            int size = queue.size();
//            for (int z = 0; z < size; z++) {
//                Node node = queue.poll();
//                if (node.y == t) {
//                    return cnt;
//                }
//                int my = node.y - 2;
//                int py = node.y + 2;
//
//
//                for (int i = my; i <= py; i++) {
//                    if (i < 0 || i > 200_001) {
//                        continue;
//                    }
//
//                    for (int j = 0; j < nodes[i].size(); j++) {
//                        if (node.x + 2 < nodes[i].get(j)) {
//                            break;
//                        } else if (node.x - 2 > nodes[i].get(j)) {
//                            continue;
//                        }
//                        int x = nodes[i].remove(j);
//
//                        queue.add(new Node(i, x));
//                        j--;
//                    }
//                }
//            }
//            cnt++;
//        }
//        return -1;
//    }
//
//    static class Node {
//        int y;
//        int x;
//
//        public Node(int y, int x) {
//            this.y = y;
//            this.x = x;
//        }
//    }
//}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] nodes;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        nodes = new ArrayList[200_001];
        for (int i = 0; i < 200_001; i++) {
            nodes[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            nodes[y].add(x);
        }
        for (int i = 0; i < 200_001; i++) {
            Collections.sort(nodes[i]);
        }
        System.out.println(bfs(t));
    }

    static int bfs(int t) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0, 0));

        int cnt = 0;
        while (!queue.isEmpty()) {

            int size = queue.size();
            for (int z = 0; z < size; z++) {
                Node node = queue.poll();
                if (node.y == t) {
                    return cnt;
                }
                int my = node.y - 2;
                int py = node.y + 2;


                for (int i = my; i <= py; i++) {
                    if (i < 0 || i > 200_001) {
                        continue;
                    }

                    for (int j = 0; j < nodes[i].size(); j++) {
                        if (node.x + 2 < nodes[i].get(j)) {
                            break;
                        } else if (node.x - 2 > nodes[i].get(j)) {
                            continue;
                        }

                        if (Math.abs(nodes[i].get(j) - node.x) <= 2) {
                            int x = nodes[i].remove(j);

                            queue.add(new Node(i, x));
                            j--;
                        }
                    }
                }
            }
            cnt++;
        }
        return -1;
    }

    static class Node {
        int y;
        int x;

        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}