import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int n = nums.length / 2;
        Set<Integer> set = new HashSet<>();
        for (int num: nums) {
            set.add(num);
        }
        answer = Math.min(n, set.size());
        return answer;
    }
}
