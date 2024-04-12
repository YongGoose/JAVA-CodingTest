import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int[][] result = new int[triangle.length][triangle.length];
        result[0][0] = triangle[0][0];
        
        for(int i = 1; i < triangle.length; i++) {
            for(int j = 0; j < triangle[i].length; j++) {
                if(j == 0) {
                    result[i][j] = result[i - 1][j] + triangle[i][j];
                } else if(j == triangle[i].length - 1) {
                    result[i][j] += result[i - 1][triangle[i - 1].length - 1] + triangle[i][j];
                } else {
                    int plus = Math.max(result[i - 1][j], result[i - 1][j - 1]);
                    result[i][j] += plus + triangle[i][j];
                }
            }
        }
        int answer = 0;
        for(int i = 0; i < triangle[triangle.length - 1].length; i++) {
            answer = Math.max(answer, result[triangle.length - 1][i]);
        }
        
        return answer;
    }
}