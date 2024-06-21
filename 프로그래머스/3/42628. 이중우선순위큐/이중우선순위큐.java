import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> minPq = new PriorityQueue<>();
        PriorityQueue<Integer> maxPq = new PriorityQueue<>(Comparator.reverseOrder());
        
        for(String operation : operations) {
            StringTokenizer st = new StringTokenizer(operation);
            
            if(st.nextToken().equals("I")) {
                int num = Integer.parseInt(st.nextToken());
                minPq.offer(num);
                maxPq.offer(num);
                continue;
            }
            
            if(minPq.isEmpty()) {
                continue;
            }
            
            if(st.nextToken().equals("1")) {
                int removeNumber = maxPq.poll();
                minPq.remove(removeNumber);
            } else {
                int removeNumber = minPq.poll();
                maxPq.remove(removeNumber);
            }
        }
        int[] answer;
        
        if(maxPq.isEmpty()) {
            answer = new int[] {0, 0};
        } else {
            answer = new int[] {maxPq.peek(), minPq.peek()};
        }
        return answer;
    }
}