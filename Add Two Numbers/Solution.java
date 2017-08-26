// https://leetcode.com/problems/add-two-numbers
// 
// You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
// You may assume the two numbers do not contain any leading zero, except the number 0 itself.
// 
// Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
// Output: 7 -> 0 -> 8
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
