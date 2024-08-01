package scv1702.easy;

import scv1702.data.TreeNode;

public class ConvertSortedArrayToBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length-1);
    }

    public TreeNode sortedArrayToBST(int[] nums, int i, int j) {
        if (i > j) return null;
        int mid = (i + j) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = sortedArrayToBST(nums, i, mid-1);
        node.right = sortedArrayToBST(nums, mid+1, j);
        return node;
    }
}
