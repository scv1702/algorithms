package Leetcode.Easy;

import java.util.*;

public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        if (nums.length <= 1) return false;
        Set<Integer> set = new HashSet<>();
        for (int num: nums) {
            if (set.contains(num)) return true;
            set.add(num);
        }        
        return false;
    }
}