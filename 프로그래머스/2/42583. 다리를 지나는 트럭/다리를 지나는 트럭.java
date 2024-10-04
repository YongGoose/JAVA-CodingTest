import java.util.*;
import java.io.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        
        Queue<Integer> queue = new LinkedList<>();
        int currentWeight = 0;
        int answer = 0;
        
        for(int truck : truck_weights) {
            
            if(truck > weight) {
                continue;
            }
            
            while(true) {
                if(queue.isEmpty()) {
                    queue.add(truck);
                    answer += 1;
                    currentWeight += truck;
                    break;
                }
            
                if(queue.size() == bridge_length) {
                    currentWeight -= queue.poll();
                    continue;
                }

                if(currentWeight + truck <= weight) {
                    queue.add(truck);
                    currentWeight += truck;
                    answer += 1;
                    break;
                }
                
                if(currentWeight + truck > weight) {
                    queue.offer(0);
                    answer++;
                }
            }
        }
        if(!queue.isEmpty()) {
            answer += bridge_length;
        }
        return answer;
    }
}