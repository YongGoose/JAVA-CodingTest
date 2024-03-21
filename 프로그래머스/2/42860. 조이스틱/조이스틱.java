import java.util.*;
import java.io.*;

class Solution {
    public int solution(String name) {
        int cnt = 0;
        
        int length = name.length();
        int movement = length - 1;
        for(int i = 0; i < length; i++){
            cnt += calculateLetter(name.charAt(i));
            
            int index = i + 1;
            while(index < length && name.charAt(index) == 'A'){
                index += 1;
            }
            movement = Math.min(movement, i * 2 + length - index);
            movement = Math.min(movement, (length - index) * 2 + i);
        }
        int answer = cnt + movement;
        return answer;
    }
    
    
    private int calculateLetter(char alphabet){
        int num = alphabet - 'A';
        if(num <= 13){
            return num;
        } else {
            return 25 - num + 1;
        }
    }
}