import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        
        ArrayList<Integer>[] arrays = new ArrayList[n + 1];
        
        for(int i = 0; i < n + 1; i++) {
            arrays[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < n - 1; i++) {
            int[] wire = wires[i];
            arrays[wire[0]].add(wire[1]);
            arrays[wire[1]].add(wire[0]);
        }
        
        int result = Integer.MAX_VALUE;
        for(int i = 0; i < n - 1; i++) {
            int[] removeWire = wires[i];
            arrays[removeWire[0]].remove(Integer.valueOf(removeWire[1]));
            arrays[removeWire[1]].remove(Integer.valueOf(removeWire[0]));
            
            boolean[] visited = new boolean[n + 1];
            
            Queue<Integer> list = new LinkedList<>();
            list.add(wires[0][0]);
            
            int res = 0;
            while(!list.isEmpty()) {
                int currentNode = list.poll();
                res++;
                
                visited[currentNode] = true;
                for(int node : arrays[currentNode]) {
                    if(visited[node]) {
                        continue;
                    }
                    list.add(node);
                }
            }
            
            int semiResult = n - res;
            result = Math.min(result, Math.abs(semiResult - res));
            
            arrays[removeWire[0]].add(removeWire[1]);
            arrays[removeWire[1]].add(removeWire[0]);
            
        }
        return result;
    }
}