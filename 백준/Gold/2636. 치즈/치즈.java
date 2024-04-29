import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static boolean[][] cheezeArray;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int y, x;
    static ArrayList<int[]> clearNumbers = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        y = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        cheezeArray = new boolean[y][x];
        for (int i = 0; i < y; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < x; j++) {
                String input = st.nextToken();
                cheezeArray[i][j] = input.equals("1");
            }
        }
        int cnt = 1, result = 0;

        while (true) {
            boolean[][] visited = new boolean[y][x];
            for (int i = 0; i < cheezeArray.length; i++) {
                for (int j = 0; j < cheezeArray[0].length; j++) {
                    if (!cheezeArray[i][j] && !visited[i][j]) {
                        bfs(visited, i, j);
                    }
                }
            }

            int size = removeCheeze();
            if (!checkCheezeExists()) {
                result = size;
                break;
            }
            cnt++;
        }
        System.out.println(cnt + "\n" + result);
    }

    static boolean checkCheezeExists() {
        for (boolean[] cheeze : cheezeArray) {
            for (boolean ch : cheeze) {
                if (ch) {
                    return true;
                }
            }
        }
        return false;
    }

    static int removeCheeze() {
        int size = clearNumbers.size();

        for (int[] remove : clearNumbers) {
            cheezeArray[remove[0]][remove[1]] = false;
        }
        clearNumbers.clear();
        return size;
    }

    static void bfs(boolean[][] visited, int y, int x) {
        boolean isFlag = false;
        ArrayList<int[]> clearNumber = new ArrayList<>();
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{y, x});

        while (!queue.isEmpty()) {
            int[] node = queue.poll();

            if (node[0] == 0 || node[1] == 0) {
                isFlag = true;
            }

            if (!visited[node[0]][node[1]]) {
                visited[node[0]][node[1]] = true;
            }

            for (int i = 0; i < 4; i++) {
                int ny = node[0] + dy[i];
                int nx = node[1] + dx[i];
                if (!isOnBoard(ny, nx)) {
                    continue;
                }

                if (!visited[ny][nx]) {
                    if (cheezeArray[ny][nx]) {
                        clearNumber.add(new int[]{ny, nx});
                    } else {
                        queue.add(new int[]{ny, nx});
                    }
                    visited[ny][nx] = true;
                }
            }
        }
        if (isFlag) {
            clearNumbers.addAll(clearNumber);
        }
    }

    static boolean isOnBoard(int ylen, int xlen) {
        return ylen >= 0 && ylen < y && xlen >= 0 && xlen < x;
    }
}