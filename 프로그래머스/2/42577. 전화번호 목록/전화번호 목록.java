import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        ArrayList<String> strings = new ArrayList<>();
        
        for(int i = 0; i < phone_book.length; i++) {
            String input = phone_book[i];
            strings.add(input);
        }
        
        Collections.sort(strings);
        for(int i = 0; i < strings.size() - 1; i++) {
            String first = strings.get(i);
            String second = strings.get(i + 1);
            
            int length = Math.min(first.length(), second.length());
            
            int cnt = 0;
            for(int j = 0; j < length; j++) {
                if(first.charAt(j) == second.charAt(j)) {
                    cnt++;
                }
            }
            if (cnt == length) {
                return false;
            }
        }
        return true;
    }
}