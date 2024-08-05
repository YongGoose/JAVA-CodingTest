import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        Arrays.sort(routes, Comparator.comparingInt(a -> a[1]));
        
        int end = routes[0][1];
        int answer = 1;
        for(int[] route : routes) {
            if(route[0] > end) {
                answer++;
                end = route[1];
            }
        }
        return answer;
    }
}