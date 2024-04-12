import java.util.*;

class Solution {
    private boolean[][] visited;
    private int[][] value;
    private int[] dx = {-1,1,0,0};
    private int[] dy = {0,0,-1,1};
    public int solution(int[][] maps) {
        // BFS로 구현하기, 최적길이는 BFS로 풀어야 수월함.
        visited = new boolean[maps.length][maps[0].length];
        value = new int[maps.length][maps[0].length];
        
        BFS(0, 0, maps);
        if(value[maps.length - 1][maps[0].length - 1] == 0) {
            return -1;
        }
        return value[maps.length - 1][maps[0].length - 1];
    }
    static class Node {
        int y;
        int x;
        int count;
        
        public Node(int y, int x, int count) {
            this.y = y;
            this.x = x;
            this.count = count;
        }
    }
    public void BFS(int y, int x, int[][] maps) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0,0,1));
        value[0][0]++;
        while(!queue.isEmpty()) {
            Node node = queue.poll();
            for(int i = 0; i < 4; i++) {
                int newY = node.y + dy[i];
                int newX = node.x + dx[i];
                if(!isOnBoard(newY, newX, maps)) {
                    continue;
                }
                if(!visited[newY][newX] && maps[newY][newX] == 1) {
                    value[newY][newX] = value[node.y][node.x] + 1;
                    queue.add(new Node(newY,newX,node.count + 1));
                    visited[newY][newX] = true;
                }
            }
        }
    }
    
    public boolean isOnBoard(int y, int x, int[][] maps) {
        return y >= 0 && x >= 0 && y < maps.length && x < maps[0].length;
    }
    public void isVisted(Node node) {
        visited[node.y][node.x] = true;
    }
}