class Solution {
    public long solution(int n, int[] times) {
        long maxValue = 0;
        for(int time : times) {
            maxValue = Math.max(maxValue, time);
        }
        
        long start = 0, end = n * maxValue;
        System.out.println(end);
        long answer = 0;
        while(start <= end) {
            long mid = (start + end) / 2;
            long res = compareTime(mid, times);
            
            if(res >= n) {
                answer = mid;
                end = mid - 1;
                continue;
            }
            start = mid + 1;
        }
        return answer;
    }
    
    private long compareTime(long t, int[] times) {
        long result = 0;
        
        for(int time : times) {
            result += t / time;
        }
        
        return result;
    }
}