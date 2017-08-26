// https://leetcode.com/problems/rotate-list
// 
// Given a list, rotate the list to the right by k places, where k is non-negative.
// For example:
// Given 1->2->3->4->5->NULL and k = 2,
// return 4->5->1->2->3->NULL.
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) return head;
        if (head.next == null) return head;
        int len = 0;
        ListNode l = head;
        while (l != null) {
            l = l.next;
            len++;
        }
        if (k == len) {
            return head;
        }
        k %= len;
        if (k == 0) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null) {
            fast = fast.next;
            if (--k <= 0) {
                slow = slow.next;
            }
        }
        ListNode current = head;
        while (current.next != slow) {
            current = current.next;
        }
        current.next = null;
        ListNode temp = slow;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = head;
        return slow;
    }
}
