import java.util.*;

class Solution {
    private List<Set<Integer>> numbers = new ArrayList<>();
    public int solution(int N, int number) {
        return dp(N, number); 
    }
    
    public int dp(int N, int number) {
        if (number == N) {
            return 1;
        }
        
        for(int i = 0; i < 9; i++) {
            numbers.add(new HashSet<>());
        }
        
        numbers.get(1).add(N);
        String n = String.valueOf(N);        
        for(int i = 2; i < 9; i++) {
            Set<Integer> set = numbers.get(i);
            
            for(int j = 1; j < i; j++) {
                operation(set, numbers.get(i - j), numbers.get(j));
                operation(set, numbers.get(j), numbers.get(i - j));
            }
            set.add(Integer.parseInt(n.repeat(i)));
            for(int num : numbers.get(i)) {
                if(num == number) {
                    return i;
                }
            }
        }
        return -1;   
    }
    public void operation(Set<Integer> result, Set<Integer> first, Set<Integer> second) {
        for(int firstNum : first) {
            for(int secondNum : second) {
                result.add(firstNum + secondNum);
                result.add(firstNum - secondNum);
                result.add(firstNum * secondNum);
                if (firstNum != 0 && secondNum != 0) {
                    result.add(firstNum / secondNum);
                }
            }
        }
    }
}