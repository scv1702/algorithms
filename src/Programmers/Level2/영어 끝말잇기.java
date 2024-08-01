import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        Set<String> set = new HashSet<>();
        int[] answer = new int[2];
        set.add(words[0]);
        for (int i = 1; i < words.length; i++) {
            if (words[i-1].charAt(words[i-1].length()-1) != words[i].charAt(0) ||
                set.contains(words[i])) {
                answer[0] = (i % n) + 1;
                answer[1] = (i / n) + 1;
                break;
            }
            set.add(words[i]);
        }
        return answer;
    }
}
