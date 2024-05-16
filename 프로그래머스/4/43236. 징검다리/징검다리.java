import java.util.*;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        Arrays.sort(rocks);
        int length = rocks.length;
        
        int[] btrocks = new int[length + 1];
        btrocks[0] = rocks[0];
        btrocks[length] = distance - rocks[length - 1];
        
        for(int i = 1; i < length; i++) {
            btrocks[i] = rocks[i] - rocks[i - 1];
        }
        
        int start = 1;
        int end = distance;
        int answer = 0;
        
        while(start <= end) {
            int mid = (start + end) / 2;
             
            int cnt = calculateStone(mid, btrocks, n);
            if(cnt > n) {
                end = mid - 1;
            } else {
                answer = mid;
                start = mid + 1;
            }
                
        }
        return answer;
    }
    private int calculateStone(int mid, int[] btrocks, int n) {
        int sum = 0;
        int cnt = 0;
        for(int i = 0; i < btrocks.length; i++) {
            if(cnt > n) {
                break;
            }
            
            sum += btrocks[i];
            if(sum < mid) {
                cnt++;
                continue;
            }
            sum = 0;
        }
        return cnt;
    }
}