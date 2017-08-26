// https://leetcode.com/problems/merge-two-binary-trees
// 
// 
// Given two binary trees and imagine that when you put one of them to cover the other, some nodes of the two trees are overlapped while the others are not. 
// 
// 
// You need to merge them into a new binary tree. The merge rule is that if two nodes overlap, then sum node values up as the new value of the merged node. Otherwise, the NOT null node will be used as the node of new tree.
// 
// Example 1:
// 
// Input: 
// 	Tree 1                     Tree 2                  
//           1                         2                             
//          / \                       / \                            
//         3   2                     1   3                        
//        /                           \   \                      
//       5                             4   7                  
// Output: 
// Merged tree:
// 	     3
// 	    / \
// 	   4   5
// 	  / \   \ 
// 	 5   4   7
// 
// 
// Note:
// The merging process must start from the root nodes of both trees.
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
