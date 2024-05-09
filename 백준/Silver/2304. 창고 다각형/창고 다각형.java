import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static class Pillar implements Comparable<Pillar> {
        int w;
        int len;

        public Pillar(int w, int len) {
            this.w = w;
            this.len = len;
        }

        @Override
        public int compareTo(Pillar o) {
            return this.w - o.w;
        }
    }

    static ArrayList<Pillar> pillars = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int testCase = Integer.parseInt(st.nextToken());

        for (int i = 0; i < testCase; i++) {
            st = new StringTokenizer(br.readLine());

            int w = Integer.parseInt(st.nextToken());
            int len = Integer.parseInt(st.nextToken());

            pillars.add(new Pillar(w, len));
        }
        Collections.sort(pillars);
        System.out.println(calculate(testCase));
    }

    static int calculate(int testCase) {
        int index = findBiggestPillarIndex(testCase);
        int result = 0;
        result += pillars.get(index).len;

        for (int i = 0; i < index; i++) {
            Pillar p = pillars.get(i);

            for (int j = i + 1; j <= index; j++) {
                Pillar cp = pillars.get(j);
                if (cp.len >= p.len) {
                    i = j - 1;
                    result += (cp.w - p.w) * p.len;
                    break;
                }
            }
        }
        for (int i = testCase - 1; i > index; i--) {
            Pillar p = pillars.get(i);
            for (int j = i - 1; j >= index; j--) {
                Pillar cp = pillars.get(j);
                if (cp.len >= p.len) {
                    i = j + 1;
                    result += (p.w - cp.w) * p.len;
                    break;
                }
            }
        }
        return result;
    }

    static int findBiggestPillarIndex(int testCase) {
        int big = 0, index = 0;
        for (int i = 0; i < testCase; i++) {
            if (big < pillars.get(i).len) {
                index = i;
                big = pillars.get(i).len;
            }
        }
        return index;
    }
}