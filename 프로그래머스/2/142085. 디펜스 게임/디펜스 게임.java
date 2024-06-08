import java.util.*;

class Solution {
    public int solution(int n, int k, int enemy[]) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        int answer = 0;
        for (int en : enemy) {
            pq.offer(en);
            n -= en;
            if (n < 0) {
                if (k <= 0) {
                    return answer;
                }

                int largestNumber = pq.poll();
                n += largestNumber;
                k--;
            }
            answer++;
        }

        return answer;
    }
}