import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        Map<Character, Integer> map = new HashMap<>();
        char other = '#';
        int st = 0;
        char target = s.charAt(0);
        int last = s.length();
        int cnt = 0;
        for (int i = st; i < last; i++) {
            if (i == st) {
                target = s.charAt(st);
                map.put(target, 1);
            } else {
                char now = s.charAt(i);
                if (target == now) map.put(target, map.getOrDefault(target, 0) + 1);
                else {
                    cnt++;
                    // map.put(other, map.getOrDefault(other, 0) + 1);
                }
            }
            if (map.get(target) == cnt) {
                st = i + 1;
                answer += 1;
                map = new HashMap<>();
                cnt = 0;
            } else if (i == last - 1) answer += 1;
        }

        return answer;
    }
}