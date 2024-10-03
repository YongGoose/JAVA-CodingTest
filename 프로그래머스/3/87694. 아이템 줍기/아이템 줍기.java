class Solution {
	private char[][] map = new char[101][101];
	private boolean[][] isVisited = new boolean[101][101];
	private int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
	private int minValue = Integer.MAX_VALUE;

	public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
		for(int[] rec : rectangle) {
			draw(rec);
		}
		isVisited[characterY * 2][characterX * 2] = true;
		dfs(characterY * 2, characterX * 2, itemY * 2, itemX * 2, 0);

		return minValue / 2;
	}

	public void dfs(int y, int x, int itemY, int itemX, int depth) {
		if(y == itemY && x == itemX) {
			minValue = Math.min(depth, minValue);
			return;
		}

		for(int i = 0; i < 4; i++) {
			int ny = y + dir[i][0];
			int nx = x + dir[i][1];

			if(!isOnBoard(ny, nx)) {
				continue;
			}
			if(!isVisited[ny][nx] && map[ny][nx] == '2') {
				isVisited[ny][nx] = true;
				dfs(ny, nx, itemY, itemX, depth + 1);
				isVisited[ny][nx] = false;
			}
		}
	}

	public boolean isOnBoard(int y, int x) {
		return y >= 0 && y <= 100 && x >= 0 && x <= 100;
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