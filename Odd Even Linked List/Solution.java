/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) return head;
        if (head.next == null) return head;
        ListNode odds = head;
        ListNode evens = head.next;
        ListNode tail = evens;
        ListNode nextOdd = head;
        ListNode nextEven = evens;
        while (true) {
            nextOdd = nextOdd.next.next;
            if (nextOdd == null) break;
            odds.next = nextOdd;
            odds = odds.next;
            nextEven = nextEven.next.next;
            if (nextEven == null) break;
            evens.next = nextEven;
            evens = evens.next;
        }
        evens.next = null;
        odds.next = tail;
        return head;
    }
}
