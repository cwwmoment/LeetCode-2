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

    // Updated on 8 Feb 2019
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode pre = null, cur = dummy;
        for (int i = 0; i < m; i++) {
            pre = cur;
            cur = cur.next;
        }
        
        ListNode tail = pre.next;
        ListNode preCur = null;
        for (int i = m; i <= n; i++) {
            ListNode next = cur.next;
            cur.next = preCur;
            preCur = cur;
            cur = next;
        }
        
        tail.next = cur;
        pre.next = preCur;
        return dummy.next;
    }
}
