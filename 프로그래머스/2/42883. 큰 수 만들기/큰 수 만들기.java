import java.io.*;

class Solution {
    public String solution(String number, int k) {
        // 작은 계산의 해로 전체의 정답을 구한다.
        StringBuilder sb = new StringBuilder();
        int idx = 0, minusIdx = 0;
        while(k > 0) {
            int maxNumber = Integer.MIN_VALUE, maxIdx = -1;            
            for(int i = idx; i < idx + k + 1; i++) {
                int currentNumber = number.charAt(i) - '0';
                if(maxNumber < currentNumber) {
                    maxIdx = i;
                    maxNumber = currentNumber;
                }
            }
            sb.append(maxNumber);
            k -= (maxIdx - idx);
            idx = maxIdx + 1;
            
            if(idx + k + 1 > number.length()) {
                minusIdx = k;
                break;
            }
        }
        for(int i = idx; i < number.length() - minusIdx; i++) {
            sb.append(number.charAt(i));
        }
        return sb.toString();
    }
}