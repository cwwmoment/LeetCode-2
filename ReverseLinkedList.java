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
}
