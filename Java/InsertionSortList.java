/**
 * Created on 14 Nov 2018 by happygirlzt
 *
 * LeetCode
 *
 */

public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode pre = dummy;
        ListNode cur = head;

        while (cur != null) {
            pre = dummy;

            while (pre.next != null && pre.next.val < cur.val) {
                pre=pre.next;
            }

            ListNode next = cur.next;
            cur.next = pre.next;
            pre.next = cur;
            cur = next;
        }

        return dummy.next;
    }
}
