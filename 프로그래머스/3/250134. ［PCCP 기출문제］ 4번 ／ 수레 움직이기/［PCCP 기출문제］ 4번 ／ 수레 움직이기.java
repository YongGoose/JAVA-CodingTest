import java.util.*;

class Solution {
    private static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    private static int height, length;
    private static int[] blueEnd, redEnd;
    private static int answer = Integer.MAX_VALUE;
    private static int[][] map;
    private static boolean[][] redVisited, blueVisited;
    
    public int solution(int[][] maze) {
        map = maze;
        height = maze.length;
        length = maze[0].length;
        
        int[] blue = new int[2];
        blueEnd = new int[2];
        int[] red = new int[2];
        redEnd = new int[2];
        
        for(int i = 0; i < height; i++) {
            for(int j = 0; j < length; j++) {
                int currentNum = maze[i][j];
                
                if(currentNum == 1) {
                    red[0] = i;
                    red[1] = j;
                } else if(currentNum == 2) {
                    blue[0] = i;
                    blue[1] = j;
                } else if(currentNum == 3) {
                    redEnd[0] = i;
                    redEnd[1] = j;
                } else if(currentNum == 4) {
                    blueEnd[0] = i;
                    blueEnd[1] = j;
                }
            }
        }
        
        redVisited = new boolean[height][length];
        blueVisited = new boolean[height][length];
        
        redVisited[red[0]][red[1]] = true;
        blueVisited[blue[0]][blue[1]] = true;
        
        backTracking(red, blue, 0);
        
        return answer == Integer.MAX_VALUE ? 0 : answer;
    }
    
    private static void backTracking(int[] red, int[] blue, int count) {
        if(red[0] == redEnd[0] && red[1] == redEnd[1] && blue[0] == blueEnd[0] && blue[1] == blueEnd[1]) {
            answer = Math.min(answer, count);
            return;
        }
        
        if(count >= answer) return;  // 가지치기
        
        boolean redAtEnd = (red[0] == redEnd[0] && red[1] == redEnd[1]);
        boolean blueAtEnd = (blue[0] == blueEnd[0] && blue[1] == blueEnd[1]);
        
        List<int[]> redMoves = new ArrayList<>();
        List<int[]> blueMoves = new ArrayList<>();
        
        if(redAtEnd) {
            redMoves.add(red);
        } else {
            for(int[] d : dir) {
                int nRedY = red[0] + d[0];
                int nRedX = red[1] + d[1];
                
                if(isValidMove(nRedY, nRedX) && !redVisited[nRedY][nRedX]) {
                    redMoves.add(new int[]{nRedY, nRedX});
                }
            }
        }
        
        if(blueAtEnd) {
            blueMoves.add(blue);
        } else {
            for(int[] d : dir) {
                int nBlueY = blue[0] + d[0];
                int nBlueX = blue[1] + d[1];
                
                if(isValidMove(nBlueY, nBlueX) && !blueVisited[nBlueY][nBlueX]) {
                    blueMoves.add(new int[]{nBlueY, nBlueX});
                }
            }
        }
        
        for(int[] redMove : redMoves) {
            for(int[] blueMove : blueMoves) {
                if(redMove[0] == blueMove[0] && redMove[1] == blueMove[1]) continue;
                if(redMove[0] == blue[0] && redMove[1] == blue[1] && blueMove[0] == red[0] && blueMove[1] == red[1]) continue;
                
                redVisited[redMove[0]][redMove[1]] = true;
                blueVisited[blueMove[0]][blueMove[1]] = true;
                
                backTracking(redMove, blueMove, count + 1);
                
                if(!redAtEnd) redVisited[redMove[0]][redMove[1]] = false;
                if(!blueAtEnd) blueVisited[blueMove[0]][blueMove[1]] = false;
            }
        }
    }
    
    private static boolean isValidMove(int y, int x) {
        return y >= 0 && y < height && x >= 0 && x < length && map[y][x] != 5;
    }
}