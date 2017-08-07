/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return helper(nums, 0, nums.length);
    }

    private TreeNode helper(int[] nums, int start, int end) {
        if (start >= end) return null;
        int max = Integer.MIN_VALUE;
        int position = 0;
        for (int i = start; i < end; i++) {
            if (nums[i] > max) {
                max = nums[i];
                position = i;
            }
        }
        TreeNode root = new TreeNode(max);
        root.left = helper(nums, start, position);
        root.right = helper(nums, position + 1, end);
        return root;
     }
}
