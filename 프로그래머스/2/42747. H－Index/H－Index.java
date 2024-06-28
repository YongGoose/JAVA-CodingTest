import java.util.*;

class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        
        int length = citations.length;
        int result = 0;
        
        for(int i = 1; i <= citations[length - 1]; i++) {
            
            int cnt = 0;
            for(int j = 0;j < length; j++) {
                if(citations[j] >= i) {
                    cnt++;
                }
            }
            System.out.println("cnt : " + cnt + " i : " + i);
            if(cnt >= i) {
                result = i;
            } else {
                break;
            }
        }
        return result;
    }
}