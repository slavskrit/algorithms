// https://leetcode.com/problems/equal-tree-partition
// 
// Given a binary tree with n nodes, your task is to check if it's possible to partition the tree to two trees which have the equal sum of values after removing exactly one edge on the original tree.
// 
// Example 1:
// Input:     
//     5
//    / \
//   10 10
//     /  \
//    2   3
// 
// Output: True
// Explanation: 
//     5
//    / 
//   10
//       
// Sum: 15
// 
//    10
//   /  \
//  2    3
// 
// Sum: 15
// Example 2:
// Input:     
//     1
//    / \
//   2  10
//     /  \
//    2   20
// 
// Output: False
// Explanation: You can't split the tree into two trees with equal sum after removing exactly one edge on the tree.
// Note:
// The range of tree node value is in the range of [-100000, 100000].
// 1 <= n <= 10000
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean checkEqualTree(TreeNode root) {
        if (root == null) return false;
        Map<Integer, Integer> map = new HashMap<>();
        int sum = getSum(root, map);
        if (sum == 0) return map.getOrDefault(sum, 0) > 1;
        return ((sum & 1) == 0) & map.containsKey(sum / 2);
    }

    private int getSum(TreeNode root, Map<Integer, Integer> map) {
        if (root == null) return 0;
        int left = getSum(root.left, map);
        int right = getSum(root.right, map);
        int value = root.val + left + right;
        map.put(value, map.getOrDefault(value, 0) + 1);
        return value;
    }
}
