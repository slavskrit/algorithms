public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return null;
        if (head.next == null && n == 1) return null;
        ListNode slow = head;
        ListNode fast = head;
        int counter = 0;
        while (counter < n) {
            fast = fast.next;
            counter++;
        }
        if (fast == null) return head.next;
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;    
        return head;
    }
}
