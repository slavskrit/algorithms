// https://leetcode.com/problems/path-sum-iii
// 
// You are given a binary tree in which each node contains an integer value.
// Find the number of paths that sum to a given value.
// The path does not need to start or end at the root or a leaf, but it must go downwards
// (traveling only from parent nodes to child nodes).
// The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.
// 
// Example:
// 
// root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
// 
//       10
//      /  \
//     5   -3
//    / \    \
//   3   2   11
//  / \   \
// 3  -2   1
// 
// Return 3. The paths that sum to 8 are:
// 
// 1.  5 -> 3
// 2.  5 -> 2 -> 1
// 3. -3 -> 11
// 
// 
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
    int result = 0;
    int sum = 0;

    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        this.sum = sum;
        helper(root);
        return result;
    }

    private void helper(TreeNode current) {
        calculate(current, 0);
        if (current.left != null) helper(current.left);
        if (current.right != null) helper(current.right);
    }

    private void calculate(TreeNode current, int currentSumm) {
        if (current == null) return;
        currentSumm += current.val;
        if (currentSumm == sum) result++;
        calculate(current.left, currentSumm);
        calculate(current.right, currentSumm);
    }
}
