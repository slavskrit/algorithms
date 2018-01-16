// https://leetcode.com/problems/reverse-linked-list-ii
// 
// Reverse a linked list from position m to n. Do it in-place and in one-pass.
// 
// For example:
// Given 1->2->3->4->5->NULL, m = 2 and n = 4,
// 
// return 1->4->3->2->5->NULL.
// 
// Note:
// Given m, n satisfy the following condition:
// 1 ≤ m ≤ n ≤ length of list.
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (n == m) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cursor = dummy;
        n -= m;
        while (m-- > 1) cursor = cursor.next;
        ListNode left = cursor.next;
        ListNode helper = left.next;
        while (n-- > 0) {
            left.next = helper.next;
            helper.next = cursor.next;
            cursor.next = helper;
            helper = left.next;
        }
        return dummy.next;
    }
}
