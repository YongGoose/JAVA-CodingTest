import java.util.*;

class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        return countH(citations);
    }
    public int countH(int[] citations){
        int result = 0;
        for(int i = 0; i < citations.length; i++) {
            int value = citations[i];
            if (citations.length - i >= value) {
                result = Math.max(result, value);
            } else {
                result = Math.max(result, citations.length - i);
            }
        }
        return result;
    }
}