package scv1702.medium.Subsets;

import java.util.ArrayList;
import java.util.List;

public class SubsetsRecursive {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        subsets(nums, visited, res, 0);
        return res;
    }

    public void subsets(int[] nums, boolean[] visited, List<List<Integer>> res, int idx) {
        if (idx == nums.length) {
            List<Integer> subset = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                if (visited[i]) subset.add(nums[i]);
            }
            res.add(subset);
            return ;
        }
        visited[idx] = true;
        subsets(nums, visited, res, idx + 1);
        visited[idx] = false;
        subsets(nums, visited, res, idx + 1);
    }
}
