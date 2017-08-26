// https://leetcode.com/problems/swap-nodes-in-pairs
// 
// 
// Given a linked list, swap every two adjacent nodes and return its head.
// 
// 
// For example,
// Given 1->2->3->4, you should return the list as 2->1->4->3.
// 
// 
// Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
// 
public class Solution {
    public ListNode swapPairs(ListNode head) {
       if (head == null) return null;
        if (head.next == null) return head;
        ListNode even = new ListNode(0);
        ListNode odds = new ListNode(0);
        ListNode even_current = even;
        ListNode odds_current = odds;
        ListNode current = head;
        while (current != null) {
            even_current.next = current;
            odds_current.next = current.next;
            even_current = even_current.next;
            odds_current = odds_current.next;
            if (current.next == null) break;
            current = current.next.next;
            if (current == null) even_current.next = null;
        }
        even_current = even.next;
        odds_current = odds.next;
        ListNode result = new ListNode(0);
        ListNode result_current = result;
        boolean flag = true;
        while (odds_current != null || even_current != null) {
            if (flag) {
                if (odds_current == null) {
                    flag = false;
                    continue;
                }
                result_current.next = odds_current;
                odds_current = odds_current.next;
                flag = false;
            } else {
                result_current.next = even_current;
                even_current = even_current.next;
                flag = true;
            }
            result_current = result_current.next;

        }
        return result.next; 
    }
}
