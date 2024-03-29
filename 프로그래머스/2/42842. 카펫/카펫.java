import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        return calculateCarpet(brown, yellow);
    }
    public int[] calculateCarpet(int brown, int yellow){
        int totalSize = brown + yellow;
        for(int i = 1; i < totalSize / 2 + 1; i++){
            if(totalSize % i == 0){
                if(yellowSize(totalSize / i, i, yellow)){
                    return new int[]{totalSize / i, i};
                }
            }
        }
        return new int[]{};
    }
    public boolean yellowSize(int x, int y, int yellow){
        return ((x - 2) * (y - 2)) == yellow;
    }
}