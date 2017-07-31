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
    Map<String, Boolean> map;
    List<TreeNode> result;

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        map = new HashMap<>();
        result = new ArrayList<>();
        if (root == null) return result;
        postorder(root);
        return result;
    }

    private String postorder(TreeNode root) {
        if (root == null) return "x";
        else {
            String temp = root.val + "," + postorder(root.left) + "," + postorder(root.right);
            if (map.containsKey(temp)) {
                if (map.get(temp)) {
                    map.put(temp, false);
                    result.add(root);
                }
            } else {
                map.put(temp, true);
            }
            return temp;
        }
    }
}
