class Solution {
    public int solution(String[] friends, String[] gifts) {

        int[][] giftPoints = new int[friends.length][friends.length];
        int[] result = new int[friends.length];

        for (int i = 0; i < gifts.length; i++) {
            String[] strings = gifts[i].split(" ");
            int first = 0, second = 0;
            for (int j = 0; j < friends.length; j++) {
                if (friends[j].equals(strings[0])) {
                    first = j;
                }
            }
            for (int j = 0; j < friends.length; j++) {
                if (friends[j].equals(strings[1])) {
                    second = j;
                }
            }
            giftPoints[first][second] += 1;
        }
        for (int i = 0; i < friends.length - 1; i++) {
            for (int j = i + 1; j < friends.length; j++) {
                // a와 b가 선물을 주고 받지 않은 경우 (선물 점수를 비교해서 더 큰 사람한테 1을 더한다)
                if (giftPoints[i][j] == 0 && giftPoints[j][i] == 0) {
                    int firstPoint = 0;
                    int secondPoint = 0;
                    for (int k = 0; k < friends.length; k++) {
                        firstPoint += giftPoints[i][k];
                        firstPoint -= giftPoints[k][i];
                    }
                    for (int k = 0; k < friends.length; k++) {
                        secondPoint += giftPoints[j][k];
                        secondPoint -= giftPoints[k][j];
                    }
                    // 선물 포인트가 같은 경우에는 넘어간다.
                    if (firstPoint == secondPoint) {
                        continue;
                    } else if (firstPoint > secondPoint) {
                        result[i] += 1;
                    } else {
                        result[j] += 1;
                    }
                } else {
                    if (giftPoints[i][j] > giftPoints[j][i]) {
                        result[i] += 1;
                    } else if (giftPoints[j][i] > giftPoints[i][j]) {
                        result[j] += 1;
                    } else {
                        int firstPoint = 0;
                        int secondPoint = 0;
                        for (int k = 0; k < friends.length; k++) {
                            firstPoint += giftPoints[i][k];
                            firstPoint -= giftPoints[k][i];
                        }
                        for (int k = 0; k < friends.length; k++) {
                            secondPoint += giftPoints[j][k];
                            secondPoint -= giftPoints[k][j];
                        }
                        if (firstPoint > secondPoint) {
                            result[i] += 1;
                        } else if (firstPoint < secondPoint) {
                            result[j] += 1;
                        } else {
                            continue;
                        }
                    }
                }
            }
        }
        int answer = 0;
        for (int i = 0; i < result.length; i++) {
            answer = Math.max(answer, result[i]);
        }
        return answer;
    }
}