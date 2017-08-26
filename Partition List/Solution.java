// https://leetcode.com/problems/partition-list
// 
// Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
// 
// 
// You should preserve the original relative order of the nodes in each of the two partitions.
// 
// 
// For example,
// Given 1->4->3->2->5->2 and x = 3,
// return 1->2->2->4->3->5.
// 
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
