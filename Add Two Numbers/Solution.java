public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        boolean overflow = false;
        ListNode l = new ListNode(0);
        ListNode current = l;
        while (l1 != null || l2 != null) {
            int t = 0;
            if (l1 != null) {
                t += l1.val;
            }
            if (l2 != null) {
                t += l2.val;
            }
            if (overflow) t++;
            if (t > 9) {
                t %= 10;
                overflow = true;
            } else {
                overflow = false;
            }
            ListNode temp = new ListNode(t);
            current.next = temp;
            current = current.next;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        if (overflow) {
            ListNode end = new ListNode(1);
            current.next = end;
        }
        return l.next;
    }
}
