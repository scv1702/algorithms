package scv1702.medium;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    class Permutation {
        List<List<Integer>> res;

        public Permutation(int[] arr) {
            boolean[] visited = new boolean[arr.length];
            res = new ArrayList<>();
            helper(arr, visited, new ArrayList<>());
        }

        public void helper(int[] arr, boolean[] visited, List<Integer> temp) {
            if (temp.size() == arr.length) {
                res.add(new ArrayList<>(temp));
                return;
            }
            for (int i = 0; i < arr.length; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    temp.add(arr[i]);
                    helper(arr, visited, temp);
                    temp.remove(temp.size() - 1);
                    visited[i] = false;
                }
            }
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        return new Permutation(nums).res;
    }
}
