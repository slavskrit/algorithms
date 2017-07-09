/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null) return head;
        if (head.next == null) return head;
        if (head.next.next == null) {
            ListNode temp = head;
            head = head.next;
            head.next = temp;
            head.next.next = null;
            return head;
        }
        ListNode back = head;
        ListNode mid = back.next;
        ListNode front = mid.next;
        back.next = null;
        while (front != null) {
            mid.next = back;
            ListNode temp = front.next;
            front.next = mid;
            back = mid;
            mid = front;
            front = temp;
        }
        return mid;
    }
}
