/**
 * Created on 15 Jul 2018 by happygirlzt
 *
 * LeetCode #206. Reverse Linked List
 */

class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        if (head  == null || head.next == null)
            return head;

        ListNode current = head;
        ListNode previous = null;
        ListNode next = null;

        while(current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        return previous;
    }

    // 二刷
    public ListNode reverseList1(ListNode head) {
        ListNode pre = null;
        ListNode next = null;
        ListNode cur = head;

        while (cur != null) {
            next = cur.next; // 先将cur.next存着
            cur.next = pre; // 翻转一下，cur.next变成pre
            pre = cur; // pre往后移一格
            cur = next; // cur也往后移一格
        }

        return pre;
    }

    // Updated on 4 Mar 2019
    // Recursive
    ListNode reverseList(ListNode head) {
        if (head == null || head.next.next == null) return head;
        ListNode prev = reverseList(head.next);
        head.next.next = prev;
        head.next = null;
        return prev;
    }
}
