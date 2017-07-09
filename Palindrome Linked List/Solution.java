/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null) return true;
        int mid = 0;
        ListNode current = head.next;
        while (current != null) {
            mid++;
            current = current.next;
        }
        mid /= 2;
        ListNode prev = head;
        current = head.next;
        while (mid-- > 0) {
            prev = prev.next;
            current = current.next;
        }
        prev.next = null;
        ListNode secondHead = reverse(current);
        ListNode firstHead = head;
        while (firstHead != null) {
            if (secondHead == null && firstHead.next == null) return true;
            if (firstHead.val != secondHead.val) return false;
            firstHead = firstHead.next;
            secondHead = secondHead.next;
        }
        return true;
    }

    ListNode reverse(ListNode node) {
        ListNode prev = null;
        ListNode current = node;
        ListNode next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        node = prev;
        return node;
    }
}
