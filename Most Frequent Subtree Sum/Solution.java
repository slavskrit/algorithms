// https://leetcode.com/problems/most-frequent-subtree-sum
// 
// Given the root of a tree, you are asked to find the most frequent subtree sum. The subtree sum of a node is defined as the sum of all the node values formed by the subtree rooted at that node (including the node itself). So what is the most frequent subtree sum value? If there is a tie, return all the values with the highest frequency in any order.
// 
// Examples 1
// Input:
// 
//   5
//  /  \
// 2   -3
// return [2, -3, 4], since all the values happen only once, return all of them in any order.
// Examples 2
// Input:
// 
//   5
//  /  \
// 2   -5
// return [2], since 2 happens twice, however -5 only occur once.
// Note: You may assume the sum of values in any subtree is in the range of 32-bit signed integer.
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
    public int[] findFrequentTreeSum(TreeNode root) {
        if (root == null) return new int[]{};
        Map<TreeNode, Integer> map = new HashMap<>();
        Map<Integer, Integer> count = new HashMap<>();
        int[] max = new int[]{0};
        helper(root, map, count, max);
        List<Integer> temp = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            if (entry.getValue() == max[0]) {
                temp.add(entry.getKey());
            }
        }
        int[] result = new int[temp.size()];
        for (int i = 0; i < temp.size(); i++) result[i] = temp.get(i);
        return result;
    }

    private void helper(TreeNode root, Map<TreeNode, Integer> map, Map<Integer, Integer> count, int[] max) {
        if (root == null) return;
        helper(root.left, map, count, max);
        helper(root.right, map, count, max);
        int value = root.val + map.getOrDefault(root.left, 0) + map.getOrDefault(root.right, 0);
        map.put(root, value);
        int currentCount = count.getOrDefault(value, 0) + 1;
        count.put(value, currentCount);
        max[0] = Math.max(currentCount, max[0]);
    }
}
