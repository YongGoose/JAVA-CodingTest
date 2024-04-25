import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        //다익스트라를 통해서 문제 해결해야 함.
        ArrayList<Node>[] nodes = new ArrayList[n + 1];
        for(int i = 1; i < n + 1; i++) {
            nodes[i] = new ArrayList<>();
        }
        
        for(int[] eg : edge) {
            nodes[eg[0]].add(new Node(eg[1], 1));
            nodes[eg[1]].add(new Node(eg[0], 1));
        }
        int maxValue = 0, answer = 0;
        int[] resultArray = dijk(nodes, n);
        
        for(int i : resultArray) {
            if(i == Integer.MAX_VALUE) {
                continue;
            }
            
            maxValue = Math.max(maxValue, i);
        }
        
        for(int i : resultArray) {
            if (maxValue == i) {
                answer++;
            }
        }
        return answer;
    }
    
    public int[] dijk (ArrayList<Node>[] nodes, int n) {
        int[] resultArray = new int[n + 1];
        boolean[] visited = new boolean[n + 1];
        PriorityQueue<Node> pq = new PriorityQueue<>();
        
        Arrays.fill(resultArray, Integer.MAX_VALUE);
        resultArray[1] = 0;
        pq.add(new Node(1, 0));
        
        while(!pq.isEmpty()) {
            Node node = pq.poll();
            
            if(!visited[node.end]) {
                visited[node.end] = true;
            }
            
            for(Node gNode : nodes[node.end]) {
                if(!visited[gNode.end] && resultArray[gNode.end] > resultArray[node.end] + gNode.value) {
                    resultArray[gNode.end] = resultArray[node.end] + gNode.value;
                    pq.add(new Node(gNode.end, resultArray[gNode.end]));
                }
            }
        }
        return resultArray;
    }
    static class Node implements Comparable<Node> {
        int end;
        int value;
        
        public Node (int end, int value) {
            this.end = end;
            this.value = value;
        }
        
        @Override
        public int compareTo(Node o) {
            return this.value - o.value;
        }
    }
}