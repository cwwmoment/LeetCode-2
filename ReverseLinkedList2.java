/**
 * Created on 29 Sep 2018 by happygirlzt
 *
 * LeetCode #92. Reverse Linked List II
 */

public class ReverseLinkedList2 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        int k = n - m;
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode pre = dummy;
        while (m > 1) {
            pre = pre.next;
            m--;
        }

        ListNode start = pre.next;
        ListNode then = start.next;

        while (k > 0) {
            start.next = then.next;
            then.next = pre.next;
            pre.next = then;
            then = start.next;
            k--;
        }

        return dummy.next;
    }
}
