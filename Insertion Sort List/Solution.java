// https://leetcode.com/problems/insertion-sort-list
// 
// Sort a linked list using insertion sort.
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode insertionSortList(ListNode head) {
        if (head == null) return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode current = head;
        while (current.next != null) {
            if (current.val < current.next.val) {
                current = current.next;
            } else {
                ListNode temp = current.next;
                ListNode toInsert = dummy;
                while (toInsert.next.val < temp.val) {
                    toInsert = toInsert.next;
                }
                current.next = temp.next;
                temp.next = toInsert.next;
                toInsert.next = temp;
            }
        }
        return dummy.next;
    }
}
