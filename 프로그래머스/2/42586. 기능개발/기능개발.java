import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Work> queue = new LinkedList<>();
        
        for(int i = 0; i < progresses.length; i++) {
            queue.offer(new Work(progresses[i], speeds[i]));
        }
        
        ArrayList<Integer> result = new ArrayList<>();
		while(!queue.isEmpty()) {
			if(queue.peek().progress >= 100) {
				int cnt = 1;
				queue.poll();

				while(!queue.isEmpty()) {
					if(queue.peek().progress >= 100) {
						queue.poll();
						cnt++;
					} else {
						break;
					}
				}
				result.add(cnt);
			}
			queue.forEach(Work::plusSpeed);
		}
        int[] answer = new int[result.size()];
        
        int idx = 0;
        for(Integer res : result) {
            answer[idx++] = res;
        }
        return answer;
    }
}

class Work {
    int progress;
    int speed;
    
    public Work(int progress, int speed) {
        this.progress = progress;
        this.speed = speed;
    }
    
    public void plusSpeed() {
        progress += speed;
    }
}