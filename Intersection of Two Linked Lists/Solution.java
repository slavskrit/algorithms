/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode h1 = headA;
        ListNode h2 = headB;
        while (h1 != h2) {
            if (h1 == null) {
                h1 = headB;
            } else {
                h1 = h1.next;    
            }
            if (h2 == null) {
                h2 = headA;
            } else {
                h2 = h2.next;    
            }
        }
        return h1;
    }
}
