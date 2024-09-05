package Leetcode.Easy;

import java.util.*;

public class TwoSum {
        public int[] twoSum(int[] nums, int target) {
        int[] answer = new int[2];
        Map<Integer, Integer> lookup = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (lookup.containsKey(target - nums[i])) {
                answer[0] = lookup.get(target - nums[i]);
                answer[1] = i;
                return answer;
            }
            lookup.put(nums[i], i);
        }
        return answer;
    }
}
