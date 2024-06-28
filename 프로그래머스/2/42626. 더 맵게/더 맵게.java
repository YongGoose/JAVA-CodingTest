import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        Arrays.stream(scoville)
            .forEach(pq::add);
        
        int cnt = 0;
        while(pq.size() > 1 && pq.peek() < K) {
            cnt++;
            pq.offer(calculate(pq.poll(), pq.poll()));
        }
        
        return pq.peek() >= K ? cnt : -1;
    }
    
    
    public int calculate(int first, int second) {
        return first + second * 2;
    }
}