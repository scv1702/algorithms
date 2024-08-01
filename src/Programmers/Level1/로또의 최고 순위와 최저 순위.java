import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] winNums) {
        int[] answer = new int[2];
        int sameCount = 0;
        int zeroCount = 0;
        Set<Integer> set = new HashSet<>();
        
        for (int winNum: winNums) {
            set.add(winNum);
        }
        
        for (int lotto: lottos) {
            if (lotto == 0) zeroCount++;
            if (lotto > 0 && set.contains(lotto)) {
                sameCount++;
            }
        }
      
        answer[0] = Math.min(6, Math.max(1, 7 - (sameCount + zeroCount)));
        answer[1] = Math.min(6, 7 - sameCount);
        
        return answer;
    }
}
