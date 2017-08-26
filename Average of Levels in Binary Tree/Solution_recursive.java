// https://leetcode.com/problems/average-of-levels-in-binary-tree
//
// Given a non-empty binary tree, return the average value of the nodes on each level in the form of an array.
//
// Example 1:
//
// Input:
//     3
//    / \
//   9  20
//     /  \
//    15   7
// Output: [3, 14.5, 11]
// Explanation:
// The average value of nodes on level 0 is 3,  on level 1 is 14.5, and on level 2 is 11. Hence return [3, 14.5, 11].
//
//
// Note:
//
// The range of node's value is in the range of 32-bit signed integer.
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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        Map<Integer, List<Integer>> levels = new HashMap<>();
        helper(root, levels, 0);
        for (int i = 0; i < levels.size(); i++) {
            double average = 0;
            int size = 0;
            for (int temp : levels.get(i)) {
                average += temp;
                size++;
            }
            result.add(average / size);
        }
        return result;
    }

    private void helper(TreeNode root, Map<Integer, List<Integer>> levels, int level) {
        if (root == null) return;
        List<Integer> temp = levels.get(level);
        if (temp == null) {
            temp = new ArrayList<>();
            temp.add(root.val);
        } else {
            temp.add(root.val);
        }
        levels.put(level, temp);
        helper(root.left, levels, level + 1);
        helper(root.right, levels, level + 1);
    }
}

