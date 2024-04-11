import java.util.*;

class Solution {
    private boolean[] visited;
    private Set<Integer> set = new HashSet<>();
    public int solution(String numbers) {
        int answer = 0;
        visited = new boolean[numbers.length()];
        dfs(numbers, "", 0);
        
        for(Integer num : set) {
            if(isPrime(num)) {
                answer++;
            }
        }
        return answer;
    }
    public void dfs(String numbers, String num, int depth) {
        int length = numbers.length();
        if (depth > length) {
            return;
        }
        
        for(int i = 0; i < length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                String parseNum = (num + numbers.charAt(i));
                Integer newNumber = Integer.parseInt(parseNum);
                set.add(newNumber);
                dfs(numbers, parseNum, depth + 1);
                visited[i] = false;
            }            
        }
    }
    
    public boolean isPrime(int number) {
        if(number <= 1) {
            return false;
        }
        for(int i = 2; i < number; i++) {
            if(number % i == 0) {
                return false;
            }
        }
        return true;
    }
}