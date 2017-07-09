/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode dummy = new ListNode(0);
        ListNode lesserThan = new ListNode(0);
        ListNode greaterThan = new ListNode(0);
        ListNode current = head;
        ListNode lesserCurrent = lesserThan;
        ListNode greaterCurrent = greaterThan;
        while (current != null) {
           if (current.val < x) {
               lesserCurrent.next = current;
               lesserCurrent = lesserCurrent.next;
           } else {
               greaterCurrent.next = current;
               greaterCurrent = greaterCurrent.next;
           }
            current = current.next;
        }
        greaterCurrent.next = null;
        lesserCurrent.next = greaterThan.next;
        dummy.next = lesserThan.next;
        return dummy.next;    
    }
}
