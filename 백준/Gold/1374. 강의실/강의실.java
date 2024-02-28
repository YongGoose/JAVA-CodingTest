import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
    static ArrayList<Class> arrayList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int classes = Integer.parseInt(st.nextToken());
        for (int i = 0; i < classes; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            arrayList.add(new Class(n, s, e));
        }
        Collections.sort(arrayList);

        int max = 0;
        /*
        일반적인 강의실 문제와 다르게 강의실 개수를 구하는 문제는 시작시간을 기준으로 정렬한다.
        왜냐하면 기존의 강의실 문제는 개수를 최대로 맞춰야 하는 것에 비해 강의실 개수를 출력하는 문제는 모든 회의를 가능하도록 하기 때문이다.
         */
        for (int i = 0; i < classes; i++) {
            //우선순위 큐가 비어있지 않고 가장 빨리 강의
            while (!priorityQueue.isEmpty() && priorityQueue.peek() <= arrayList.get(i).startTime) {
                priorityQueue.poll();
            }
            priorityQueue.offer(arrayList.get(i).endTime);
            max = Math.max(max, priorityQueue.size());
        }
        System.out.println(max);
    }


    static class Class implements Comparable<Class> {
        int classNum;
        int startTime;
        int endTime;

        public Class(int n, int s, int e) {
            this.classNum = n;
            this.startTime = s;
            this.endTime = e;
        }

        @Override
        public int compareTo(Class o) {
            if (this.startTime == o.startTime) {
                return this.endTime - o.endTime;
            }
            return this.startTime - o.startTime;
        }
    }
}