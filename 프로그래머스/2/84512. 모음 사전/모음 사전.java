import java.util.*;

class Solution {
    private Map<String, Integer> strings = new HashMap<>();
    private String[] w = {"A","E","I","O","U"};
    private int idx;
    public int solution(String word) {
        backTracking(0,"");
        
        return strings.get(word) + 1;
    }
    
    private void backTracking (int depth, String word) {
        if(depth <= 5 && depth > 0) {
            strings.put(word, idx++);
        } else if (depth > 5) {
            return;
        }
        
        for(int i = 0; i < 5; i++) {
            String nword = word.concat(w[i]);
            backTracking(depth + 1, nword);
        }
    }
}