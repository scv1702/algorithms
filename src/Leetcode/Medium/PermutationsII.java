package Leetcode.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsII {
    int[] temp;
    List<List<Integer>> res;

    public void helper(int[] nums, boolean[] visited, int depth) {
        if (depth == nums.length) {
            List<Integer> list = new ArrayList<>();
            for (int e : temp) {
                list.add(e);
            }
            res.add(list);
            return;
        }
        int prev = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i] && nums[i] != prev) {
                visited[i] = true;
                temp[depth] = nums[i];
                prev = temp[depth];
                helper(nums, visited, depth + 1);
                visited[i] = false;
            }
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        res = new ArrayList<>();
        temp = new int[nums.length];
        boolean[] visited = new boolean[nums.length];
        Arrays.sort(nums);
        helper(nums, visited, 0);
        return res;
    }
}
