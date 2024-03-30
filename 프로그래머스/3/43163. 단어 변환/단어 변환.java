import java.util.*;
import java.io.*;
class Solution {
    public int solution(String begin, String target, String[] words) {
        boolean isWordsInArray = false;
        for (String word : words) {
            if (target.equals(word)) {
                isWordsInArray = true;
                break;
            }
        }
        if (!isWordsInArray) {
            return 0;
        }
        //words target 확인


        Map<String, List<String>> graph = new HashMap<>();

        for (int i = 0; i < words.length ; i++) {
            String currWord = words[i];
            graph.put(currWord, new ArrayList<>());

            for (int j = 0; j < i; j++) {
                String targetWord = words[j];
                if (compareWords(currWord, targetWord)) {
                    graph.get(currWord).add(targetWord);
                    graph.get(targetWord).add(currWord);
                }
            }
        }

        graph.put(begin, new ArrayList<>());
        for (String word : words) {
            if (compareWords(begin, word)) {
                graph.get(begin).add(word);
            }
        }
        
        return bfs(begin, target, graph);
    }

    public int bfs(String begin, String target, Map<String, List<String>> graph) {
        Queue<State> queue = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();

        queue.add(new State(begin,0));

        while (!queue.isEmpty()) {
            State state = queue.poll();

            for (String word : graph.get(state.currentWord)) {
                if (visited.contains(word)) {
                    continue;
                }

                if (word.equals(target)) {
                    return state.cnt + 1;
                }

                visited.add(word);
                queue.add(new State(word, state.cnt + 1));
            }
        }
        System.out.println("!");
        return 0;
    }

    public boolean compareWords(String s1, String s2) {
        int length = s1.length();
        int cnt = 0;
        for (int i = 0; i < length; i++) {
            if (s1.charAt(i) == s2.charAt(i)) {
                cnt++;
            }
        }
        return cnt == length - 1;
    }

    class State {
        String currentWord;
        int cnt;

        public State(String currentWord, int cnt) {
            this.currentWord = currentWord;
            this.cnt = cnt;
        }
    }
}