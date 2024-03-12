class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {};
        int idx = 0;
        String[] answers = new String[100];
        answers[0] = words[0];

        while (idx < words.length - 1) {
            if (checkWord(words[idx], words[idx + 1]) && validateWord(answers, words[idx + 1], idx + 1)) {
                answers[idx + 1] = words[idx + 1];
            } else {
                System.out.println("여기서 에러 발생");
                break;
            }
            idx++;
        }

        if (answers[idx].equals(words[words.length - 1])) {
            answer = new int[]{0, 0};
        } else {
            int x = (idx + 2) % n;
            if (x == 0) {
                x = n;
            }
            int y = (idx + 2) / n;
            if((idx + 2) % n != 0){
                y += 1;
            }

            answer = new int[]{x, y};
        }
        System.out.println(answers[idx] + words[words.length - 1]);
        System.out.println(idx + 2);
        return answer;
    }


    private boolean validateWord(String[] answers, String word, int idx) {
        for (int i = 0; i < idx; i++) {
            if (answers[i].equals(word)) {
                return false;
            }
        }
        return true;
    }

    private boolean checkWord(String firstWord, String secondWord) {
        return firstWord.charAt(firstWord.length() - 1) == secondWord.charAt(0);
    }
}