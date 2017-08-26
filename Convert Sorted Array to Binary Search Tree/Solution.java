// https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree
// 
// Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
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
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) return null;
        if (nums.length == 1) return new TreeNode(nums[0]);
        int left = 0;
        int right = nums.length - 1;
        return build(nums, left, right);
    }

    private TreeNode build(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = (right + left) / 2;
        TreeNode temp = new TreeNode(nums[mid]);
        temp.left = build(nums, left, mid - 1);
        temp.right = build(nums, mid + 1, right);
        return temp;
    }
}
