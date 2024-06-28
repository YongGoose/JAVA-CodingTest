import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        Arrays.stream(scoville)
            .forEach(pq::add);
        
        int cnt = 0;
        while(pq.size() > 1) {
            if(pq.peek() >= K) {
                break;
            }
            cnt++;
            int num = calculate(pq.poll(), pq.poll());
            pq.offer(num);
        }
        
        if(pq.peek() < K) {
            return -1;
        }
        
        return cnt;
    }
    public int calculate(int first, int second) {
        return first + second * 2;
    }
}