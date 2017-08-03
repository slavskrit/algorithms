/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
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
    public TreeNode sortedListToBST(ListNode head) {
        return helper(head);
    }

    private TreeNode helper(ListNode head) {
        if (head == null) return null;
        ListNode slow = head;
        if (head.next == null) return new TreeNode(slow.val);
        ListNode fast = head.next.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode temp = slow.next;
        slow.next = null;
        TreeNode root = new TreeNode(temp.val);
        root.left = helper(head);
        root.right = helper(temp.next);
        return root;
    }
}
