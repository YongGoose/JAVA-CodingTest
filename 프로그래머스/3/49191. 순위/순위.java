class Solution {
    public int solution(int n, int[][] results) {
        // 플로이드 워셜
        int[][] graph = new int[n + 1][n + 1];
        for(int[] result : results) {
            int win = result[0];
            int lose = result[1];
            
            graph[win][lose] = 1;
            graph[lose][win] = -1;
        }
        
        for(int i = 0; i < n + 1; i++) {
            for(int j = 0; j < n + 1; j++) {
                for(int k = 0; k < n + 1; k++) {
                    if(graph[i][k] == 1 && graph[k][j] == 1) {
                        graph[i][j] = 1;
                        graph[j][i] = -1;
                    }
                    
                    if(graph[i][k] == -1 && graph[k][j] == -1) {
                        graph[i][j] = -1;
                        graph[j][i] = 1;
                    }
                }
            }
        }
        int answer = 0;
        
        for(int i = 1; i < n + 1; i++) {
            int count = 0;
            for(int j = 1; j < n + 1; j++) {
                if(graph[i][j] != 0) {
                    count++;
                }
            }
            if(count == n - 1) {
                answer++;
            }
            count = 0;
        }
        return answer;
    }
}