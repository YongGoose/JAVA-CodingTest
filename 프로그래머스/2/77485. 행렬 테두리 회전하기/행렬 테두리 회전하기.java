import java.util.*;

class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[][] map = new int[rows][columns];
        int idx = 1;
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < columns; j++) {
                map[i][j] = idx++;
            }
        }
        
        idx = 0;
        int[] results = new int[queries.length];
        for(int i = 0; i < queries.length; i++) {
            results[i] = rotate(map, queries[i]);
        }
        return results;
    }
        
    private int rotate(int[][] map, int[] query) {
        int startY = query[0] - 1;
        int startX = query[1] - 1;
        int endY = query[2] - 1;
        int endX = query[3] - 1;
        
        int temp = map[startY][startX];
        int min = temp;
        
        // 왼쪽 세로
        for(int i = startY; i < endY; i++) {
            map[i][startX] = map[i + 1][startX];
            min = Math.min(min, map[i][startX]);
        }
        
        // 아래쪽 가로
        for(int i = startX; i < endX; i++) {
            map[endY][i] = map[endY][i+1];
            min = Math.min(min, map[endY][i]);
        }
        
        // 오른쪽 세로
        for(int i = endY; i > startY; i--) {
            map[i][endX] = map[i-1][endX];
            min = Math.min(min, map[i][endX]);
        }
        
        // 위쪽 가로
        for(int i = endX; i > startX; i--) {
            map[startY][i] = map[startY][i-1];
            min = Math.min(min, map[startY][i]);
        }
        
        map[startY][startX+1] = temp;
        
        return min;
    }
}