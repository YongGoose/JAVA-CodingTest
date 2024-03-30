class Solution {
    public int solution(int n, int[][] computers) {
        boolean[] visited = new boolean[n];
        int cnt = 0;
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                visited[i] = true;
                dfs(n, computers, visited, i);
                cnt++;
            }
        }
        return cnt;
    }
    public void dfs(int n, int[][] computers, boolean[] visited, int cur){
        for(int i = 0; i < n; i++){
            if(cur == i){
                continue;
            }
            if(!visited[i] && computers[cur][i] == 1){
                visited[i] = true;
                dfs(n, computers, visited, i);
            }
        }
    }
}