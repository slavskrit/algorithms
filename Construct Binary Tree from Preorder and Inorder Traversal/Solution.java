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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return helper(0, 0, inorder.length - 1, preorder, inorder, inorder.length, map);
    }

    private TreeNode helper(int preOrderStart, int inOrderStart, int inOrderEnd,
                            int[] preorder, int[] inorder, int length, Map<Integer, Integer> map) {
        if (preOrderStart >= length || inOrderStart > inOrderEnd) return null;

        int inOrderIndex = map.get(preorder[preOrderStart]);
        TreeNode root = new TreeNode(preorder[preOrderStart]);
        root.left = helper(preOrderStart + 1, inOrderStart, inOrderIndex - 1, preorder, inorder, length, map);
        root.right = helper(preOrderStart + inOrderIndex - inOrderStart + 1, inOrderIndex + 1, inOrderEnd, preorder, inorder, length, map);
        return root;
    }

}
