import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        return calculateClothes(clothes);
    }
    public int calculateClothes(String[][] clothes){
        HashMap<String, Integer> map = new HashMap<>();
        int result = 1;
        for(int i = 0; i < clothes.length; i++){
            map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0) + 1);
        }
        for(String key : map.keySet()){
            // 안 입는 경우도 고려해야 하기에, +1을 해준다.
            result *= (map.get(key) + 1);
        }
        // 전부 안 입는 경우를 고려해서 -1을 한다.
        return result - 1;
    }
}