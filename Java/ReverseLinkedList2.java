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

    // Updated on 26 Feb 2019
    // Time O(N), Space O(1)
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode start = dummy;
        ListNode end = dummy;

        ListNode prev = dummy;
        for (int i = 0; i < m; i++) {
            prev = start;
            start = start.next;
        }

        for (int i = 0; i < n; i++) {
            end = end.next;
        }

        if (start == null || end == null) return head;
        ListNode cur = start;
        prev.next = null;

        ListNode next = end.next;
        end.next = null;
        start = reverse(start);
        prev.next = start;
        if (next != null) cur.next = next;
        return dummy.next;
    }

    private ListNode reverse(ListNode start) {
        ListNode prev = null;
        while (start != null) {
            ListNode next = start.next;
            start.next = prev;
            prev = start;
            start = next;
        }
        return prev;
    }
}
