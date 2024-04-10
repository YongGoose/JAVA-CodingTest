import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> queue = new LinkedList<>();
        int answer = 0, sum = 0;
        
        for (int truck : truck_weights) {
            while(true) {
                if (queue.isEmpty()) {
                    queue.add(truck);
                    answer++;
                    sum += truck;
                    break;
                } else {
                    if (queue.size() == bridge_length) {
                        sum -= queue.poll();
                    } else {
                        if (sum + truck > weight) {
                            queue.add(0);
                            answer++;
                        } else {
                            queue.add(truck);
                            sum += truck;
                            answer++;
                            break;
                        }
                    }
                }
            }
        }
        return answer + bridge_length;
    }
}