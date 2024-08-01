import java.util.*;

class Solution {
    public List<Integer> solution(int[] arr, int divisor) {
        List<Integer> answer = new ArrayList<>();
        for (int e: arr) {
            if (e % divisor == 0) answer.add(e);
        }
        if (answer.size() == 0) answer.add(-1);
        Collections.sort(answer);
        return answer;
    }
}
