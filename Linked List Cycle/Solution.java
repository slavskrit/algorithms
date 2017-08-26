// https://leetcode.com/problems/linked-list-cycle
// 
// 
// Given a linked list, determine if it has a cycle in it.
// 
// 
// Follow up:
// Can you solve it without using extra space?
// 
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        if (head.next == null) return false;
        if (head.next.next == null) return false;
        ListNode cursor1 = head;
        ListNode cursor2 = head.next.next;
        while(cursor2.next != null && cursor2.next.next != null) {
            cursor1 = cursor1.next;
            cursor2 = cursor2.next.next;
            if(cursor1 == cursor2) return true;
        }
        return false;
    }
}
