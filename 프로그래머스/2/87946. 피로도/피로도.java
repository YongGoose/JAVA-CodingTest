import java.util.*;

class Solution {
    private boolean[] visited;
    private int result;
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        // dfs를 이용한 완전탐색으로 구현하기
        dfs(dungeons, k, 0, 0);
        return result;
    }
    public void dfs(int[][] dungeons, int currentK, int count, int depth) {
        if(depth >= dungeons.length) {
            result = Math.max(result, count);
        }
        
        for(int i = 0; i < dungeons.length; i++) {
            if(!visited[i]) {
                if(currentK < dungeons[i][0]) {
                    visited[i] = true;
                    dfs(dungeons, currentK, count, depth + 1);
                    visited[i] = false;
                    continue;
                }
                visited[i] = true;
                dfs(dungeons, currentK - dungeons[i][1], count+1, depth + 1);
                visited[i] = false;
            }
        }
    }
}