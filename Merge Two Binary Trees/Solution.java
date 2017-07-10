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
    
    TreeNode head;
    
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == t2 ) return null;
        if (head == null) {
            if (t1 == null) return t2;
            head = t1;
        }
        if (t1 != null && t2 != null) t1.val += t2.val;
        t1.left = t1.left != null ? t1.left : (t2 != null ? t2.left : null);
        t1.right = t1.right != null ? t1.right : (t2 != null ? t2.right : null);
        mergeTrees(t1.left, t2 != null ? t2.left : t2);
        mergeTrees(t1.right, t2 != null ? t2.right : t2);
        return head;
    }
}
