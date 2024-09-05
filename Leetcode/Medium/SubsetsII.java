package Leetcode.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        Arrays.sort(nums);
        helper(nums, visited, res, 0);
        return res;
    }

    public void helper(int[] nums, boolean[] visited, List<List<Integer>> res, int idx) {
        if (idx == nums.length) {
            List<Integer> subset = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                if (visited[i]) subset.add(nums[i]);
            }
            res.add(subset);
            return ;
        }
        visited[idx] = true;
        helper(nums, visited, res, idx + 1);
        visited[idx] = false;
        while (idx + 1 < nums.length && nums[idx] == nums[idx + 1])
            idx += 1;
        helper(nums, visited, res, idx + 1);
    }
}
