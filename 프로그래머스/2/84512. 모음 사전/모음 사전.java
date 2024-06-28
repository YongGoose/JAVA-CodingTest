import java.util.*;

class Solution {
    private ArrayList<String> strings = new ArrayList<>();
    private String[] w = {"A","E","I","O","U"};
    public int solution(String word) {
        backTracking(0,"");
        
        Collections.sort(strings);
        return strings.indexOf(word) + 1;
    }
    
    private void backTracking (int depth, String word) {
        if(depth <= 5 && depth > 0) {
            strings.add(word);
        } else if (depth > 5) {
            return;
        }
        
        for(int i = 0; i < 5; i++) {
            String nword = word.concat(w[i]);
            backTracking(depth + 1, nword);
        }
    }
}