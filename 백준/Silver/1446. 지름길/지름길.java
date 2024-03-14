import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<ShortCut> shortCuts = new ArrayList<>();
    static int[] distance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        distance = new int[d + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);

        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int last = Integer.parseInt(st.nextToken());
            int length = Integer.parseInt(st.nextToken());
            if (last > d) {
                continue;
            }
            if ((last - start) <= length) {
                continue;
            }
            shortCuts.add(new ShortCut(start, last, length));
        }
        Collections.sort(shortCuts);
        distance[0] = 0;
        dp(d);
        System.out.println(distance[d]);
    }

    static void dp(int d) {
        int movement = 0;
        int idx = 0;
        while (movement < d) {
            if (idx < shortCuts.size()) {
                ShortCut shortCut = shortCuts.get(idx);
                if (shortCut.start == movement) {
                    distance[shortCut.last] = Math.min(distance[movement] + shortCut.length, distance[shortCut.last]);
                    idx++;
                } else {
                    distance[movement + 1] = Math.min(distance[movement + 1], distance[movement] + 1);
                    movement++;
                }
            } else {
                distance[movement + 1] = Math.min(distance[movement + 1], distance[movement] + 1);
                movement++;
            }
        }
    }

    static class ShortCut implements Comparable<ShortCut> {
        int start;
        int last;
        int length;

        public ShortCut(int start, int last, int length) {
            this.start = start;
            this.last = last;
            this.length = length;
        }

        @Override
        public int compareTo(ShortCut o) {
            if (this.start == o.start) {
                return this.last - o.last;
            }
            return this.start - o.start;
        }
    }
}