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

