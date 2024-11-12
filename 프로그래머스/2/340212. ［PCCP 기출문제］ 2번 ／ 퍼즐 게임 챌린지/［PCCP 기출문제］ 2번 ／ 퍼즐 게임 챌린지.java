import java.util.*;

class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        long start = 1;
        long end = Integer.MAX_VALUE;
        int result = 0;
        
        while(start <= end)
        {
            long mid = (start + end) / 2;
            long calculatedTime = calculateTime(diffs, times, mid);
            
            if(calculatedTime > limit) {
                start = mid + 1;
            } else {
                result = (int) mid;
                end = mid - 1;
            }  
        }        
        return result;
    }
    
    private long calculateTime(int[] diffs, int[] times, long level) {
        long time = 0;
        int time_prev = 0;
        
        for(int i = 0; i < diffs.length; i++) {
            int currentTime = times[i];
            if(level >= diffs[i]) {
                time += currentTime;
                time_prev = currentTime;
                continue;
            }
            
            time += currentTime;
            time += ((time_prev + currentTime) * (diffs[i] - level));
            time_prev = currentTime;
        }
        
        return time;
    }
}