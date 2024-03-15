import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static class Work implements Comparable<Work> {
        int startTime;
        int workingTime;
        int endTime;

        public Work(int workingTime, int endTime) {
            this.startTime = endTime - workingTime;
            this.workingTime = workingTime;
            this.endTime = endTime;
        }

        @Override
        public int compareTo(Work o) {
            return o.endTime - this.endTime;
        }
    }

    static ArrayList<Work> works = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int testCase = Integer.parseInt(st.nextToken());
        for (int i = 0; i < testCase; i++) {
            st = new StringTokenizer(br.readLine());
            int ti = Integer.parseInt(st.nextToken());
            int si = Integer.parseInt(st.nextToken());

            works.add(new Work(ti, si));
        }
        Collections.sort(works);
        int result = work();
        if (result == Integer.MAX_VALUE) {
            System.out.println("-1");
        } else {
            System.out.println(result);
        }

    }

    static int work() {
        int startTime = works.get(0).endTime;
        while (!works.isEmpty()) {
            Work work = works.remove(0);
            if (work.endTime < startTime) {
                startTime = work.endTime;
            }
            startTime -= work.workingTime;
        }
        if (startTime < 0) {
            return Integer.MAX_VALUE;
        }
        return startTime;
    }
}