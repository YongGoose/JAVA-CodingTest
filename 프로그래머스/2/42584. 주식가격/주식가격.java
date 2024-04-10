import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        Stack<Integer> stack = new Stack<>();
        int[] resultArray = new int[prices.length];
        
        for(int i = 0; i < prices.length - 1; i++) {
            while(!stack.isEmpty() && prices[stack.peek()] > prices[i]) {
                int idx = stack.pop();
                resultArray[idx] = i - idx;
            }
            stack.add(i);
        }
        while(!stack.isEmpty()) {
            int idx = stack.pop();
            resultArray[idx] = prices.length - 1 - idx;
        }
        return resultArray;
    }
}