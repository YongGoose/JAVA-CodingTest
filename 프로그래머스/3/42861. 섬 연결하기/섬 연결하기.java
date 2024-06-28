import java.util.*;

class Solution {
    
    private int[] parent;
    public int solution(int n, int[][] costs) {
        
        parent = new int[n];
        for(int i = 0; i < n; i++) {
            parent[i] = i;
        }
        
        PriorityQueue<Node> nodes = new PriorityQueue<>();
        for(int[] cost : costs) {
            nodes.offer(new Node(cost[0],cost[1],cost[2]));
        }
        
        int result = 0;
        for(int i = 0; i < costs.length; i++) {
            Node node = nodes.poll();
            
            int to = findParent(node.to);
            int from = findParent(node.from);
            
            if(to != from) {
                union(to,from);
                result += node.value;
            }
        }
        return result;
    }
    
    private void union(int first, int second) {        
        if(first >= second) {
            parent[second] = first;
        } else {
            parent[first] = second;
        }
    }
    
    private int findParent(int per) {
        if(parent[per] == per) {
            return per;
        }
        return findParent(parent[per]);
    }
}

class Node implements Comparable<Node> {
    int from;
    int to;
    int value;
    
    @Override
    public int compareTo(Node o) {
        return this.value - o.value;
    }
    
    public Node (int from, int to, int value) {
        this.from = from;        
        this.to = to;
        this.value = value;
    }
}