import java.util.*;

class Solution {
    static Queue<int[]>[] robotPaths; // 로봇 경로 저장
    static int robotCount;
    static int collisionCount;

    public int solution(int[][] points, int[][] routes) {
        robotCount = routes.length;
        robotPaths = new LinkedList[robotCount];
        
        // 로봇 경로 계산
        calculateRobotPaths(points, routes);
        
        // 충돌 계산
        calculateCollisions();
        
        return collisionCount;
    }

    // 각 로봇의 전체 경로 계산
    private static void calculateRobotPaths(int[][] points, int[][] routes) {
        for (int i = 0; i < robotCount; i++) {
            robotPaths[i] = new LinkedList<>();
            
            // 시작 지점 추가
            int[] startPoint = points[routes[i][0] - 1];
            robotPaths[i].add(new int[]{startPoint[0], startPoint[1]});
            
            // 각 경로 포인트 순회하며 이동 경로 계산
            int x = startPoint[0];
            int y = startPoint[1];
            
            for (int j = 1; j < routes[i].length; j++) {
                int[] nextPoint = points[routes[i][j] - 1];
                int nx = nextPoint[0];
                int ny = nextPoint[1];
                
                // x 좌표 이동 (x 우선)
                while (x != nx) {
                    x += (nx > x) ? 1 : -1;
                    robotPaths[i].add(new int[]{x, y});
                }
                
                // y 좌표 이동
                while (y != ny) {
                    y += (ny > y) ? 1 : -1;
                    robotPaths[i].add(new int[]{x, y});
                }
            }
        }
    }

    // 충돌 계산
    private static void calculateCollisions() {
        // 모든 로봇의 경로를 다 순회할 때까지 반복
        while (!areAllPathsEmpty()) {
            int[][] positionMap = new int[101][101];
            
            // 각 로봇의 현재 위치 추적
            for (int i = 0; i < robotCount; i++) {
                if (!robotPaths[i].isEmpty()) {
                    int[] currentPosition = robotPaths[i].poll();
                    positionMap[currentPosition[0]][currentPosition[1]]++;
                }
            }
            
            // 충돌 지점 계산
            for (int x = 0; x < 101; x++) {
                for (int y = 0; y < 101; y++) {
                    if (positionMap[x][y] > 1) {
                        collisionCount++;
                    }
                }
            }
        }
    }

    // 모든 로봇 경로가 비었는지 확인
    private static boolean areAllPathsEmpty() {
        for (Queue<int[]> path : robotPaths) {
            if (!path.isEmpty()) {
                return false;
            }
        }
        return true;
    }
}