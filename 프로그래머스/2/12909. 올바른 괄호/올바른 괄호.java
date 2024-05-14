import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        Stack<Character> stack = new Stack();
        
        int length = s.length();
        for(int i = 0; i < length; i++) {
            char ch = s.charAt(i);
            if(ch == '(') {
                stack.add(ch);
                continue;
            } 
            if (stack.isEmpty()) {
                answer = false;
                break;
            } else {
                char currentC = stack.peek();
                if(currentC == '(') {
                    stack.pop();
                }
            }
        }
        if(!stack.isEmpty()) {
            answer = false;
        }

        return answer;
    }
}