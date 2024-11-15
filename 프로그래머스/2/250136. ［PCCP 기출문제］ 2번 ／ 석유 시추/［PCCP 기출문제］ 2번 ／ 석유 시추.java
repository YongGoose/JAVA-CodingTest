import java.util.*;

class Solution {
    
    static class Oil implements Comparable<Oil> {
        int start;
        int end;
        int oil;
        
        public Oil(int start, int end, int oil) {
            this.start = start;
            this.end = end;
            this.oil = oil;
        }
        
        @Override
        public int compareTo(Oil o) {
            return this.start - o.start;
        }
    }
    
    private boolean[][] isVisited;
    private List<Oil> oils = new ArrayList<>();
    private int height, length;
    private int[][] dir = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    public int solution(int[][] land) {
        
        height = land.length;
        length = land[0].length;
        isVisited = new boolean[height][length];
        
        for(int i = 0; i < height; i++) {
            for(int j = 0; j < length; j++) {
                if(land[i][j] == 1 && !isVisited[i][j]) {
                    bfs(i, j, land);
                }
            } 
        }
        
        Collections.sort(oils);
        
        int answer = 0;
        for(int i = 0; i < length; i++) {
            int currentOil = 0;
            for(Oil o : oils) {
                if(o.start > i) {
                    break;
                }
                
                if(o.start <= i && o.end >= i) {
                    currentOil += o.oil;
                }
            }
            
            answer = Math.max(answer, currentOil);
        }
        return answer;
    }
    
    private void bfs(int y, int x, int[][] land) {       
        isVisited[y][x] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {y, x});
        
        int start = x;
        int end = x;
        int sum = 1;
        while(!queue.isEmpty()) {
            int[] currentPoint = queue.poll();
            
            for(int[] d : dir) {
                int ny = currentPoint[0] + d[0];
                int nx = currentPoint[1] + d[1];
                                
                if(!isOnBoard(ny, nx)) {
                    continue;
                }
                
                if(isVisited[ny][nx]) {
                    continue;
                }
                
                if(land[ny][nx] == 0) {
                    continue;
                }

                start = Math.min(start, nx);
                end = Math.max(end, nx);
                sum += land[ny][nx];
                
                isVisited[ny][nx] = true;
                queue.offer(new int[] {ny, nx});
            }
        }
        oils.add(new Oil(start, end, sum));
    }
    
    private boolean isOnBoard(int y, int x) {
        return y >= 0 && y < height && x >= 0 && x < length;
    }
}