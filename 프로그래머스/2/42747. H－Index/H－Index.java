import java.util.*;

class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        return countH(citations);
    }
    public int countH(int[] citations){
        int result = 0, index = 0;
        while(index < citations.length) {
            int value = citations[index];
            if (citations.length - index >= value) {
                System.out.println(value);
                result = Math.max(result, value);
            } else {
                System.out.println(citations.length - index);
                result = Math.max(result ,citations.length - index);
            }
            index++;
        }
        return result;
    }
}