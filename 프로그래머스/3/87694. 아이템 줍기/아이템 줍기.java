import java.util.*;
import java.io.*;

class Solution {
	private char[][] map = new char[101][101];
	private boolean[][] isVisited = new boolean[101][101];
	private int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

	public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
		for(int[] rec : rectangle) {
			draw(rec);
		}
		isVisited[characterY * 2][characterX * 2] = true;
		return bfs(characterY * 2, characterX * 2, itemY * 2, itemX * 2);
	}

	public int bfs(int y, int x, int itemY, int itemX) {
        
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{y, x, 0});
        
        
        while(!queue.isEmpty()) {
            int[] currentPoint = queue.poll();
            int cY = currentPoint[0];
            int cX = currentPoint[1];
            int result = currentPoint[2];
            
            if(cY == itemY && cX == itemX) {
                return result / 2;
            }
            

            for(int i = 0; i < 4; i++) {
                int ny = cY + dir[i][0];
                int nx = cX + dir[i][1];

                if(!isOnBoard(ny, nx)) {
                    continue;
                }
                if(!isVisited[ny][nx] && map[ny][nx] == '2') {
                    isVisited[ny][nx] = true;
                    queue.add(new int[] {ny, nx, result + 1});
                }
            }
        }
        return 0;
	}

	public boolean isOnBoard(int y, int x) {
		return y >= 2 && y < 101 && x >= 2 && x < 101;
	}

	public void draw(int[] rec) {
		int x1 = rec[0];
		int y1 = rec[1];
		int x2 = rec[2];
		int y2 = rec[3];

		for(int i = y1 * 2; i <= y2 * 2; i++) {
			for(int j = x1 * 2; j <= x2 * 2; j++) {
				if (map[i][j] == '1') {
					continue;
				}
				map[i][j] = '1';

				if(i == y1 * 2 || i == y2 * 2 || j == x1 * 2 || j == x2 * 2) {
					map[i][j] = '2';
				}
			}
		}
	}
}