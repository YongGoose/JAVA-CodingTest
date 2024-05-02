import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;

        char target = s.charAt(0);
        int st = 0;
        int last = s.length();
        int diff = 0, same = 0;
        for (int i = st; i < last; i++) {
            if (i == st) {
                target = s.charAt(st);
            }
            char now = s.charAt(i);
            if (target == now) {
                same++;
            } else {
                diff++;
            }

            if (same == diff) {
                st = i + 1;
                answer += 1;
                diff = 0;
                same = 0;
            } else if (i == last - 1) answer += 1;
        }

        return answer;
    }
}