package Leetcode.Medium.SortAnArray;

import java.util.Arrays;

public class SortAnArrayMergeSort {
    public int[] sortArray(int[] nums) {
        return mergeSort(nums);
    }

    public int[] mergeSort(int[] nums) {
        if (nums.length <= 1)
            return nums;
        int mid = nums.length / 2;
        int[] left = mergeSort(Arrays.copyOfRange(nums, 0, mid));
        int[] right = mergeSort(Arrays.copyOfRange(nums, mid, nums.length));
        return merge(left, right);
    }

    public int[] merge(int[] left, int[] right) {
        int[] aux = new int[left.length + right.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                aux[k++] = left[i++];
            } else {
                aux[k++] = right[j++];
            }
        }
        if (i >= left.length && j < right.length) {
            while (j < right.length) {
                aux[k++] = right[j++];
            }
        }
        if (i < left.length && j >= right.length) {
            while (i < left.length) {
                aux[k++] = left[i++];
            }
        }
        return aux;
    }
}
