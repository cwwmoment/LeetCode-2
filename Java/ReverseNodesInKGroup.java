/**
 * Created on 31 Oct 2018 by happygirlzt
 *
 * LeetCode #25. Reverse Nodes in k-Group
 *
 */

public class ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) return head;

        ListNode cur = head, next = head;
        int count = 0;

        while (next != null && count < k) {
            next = next.next;
            count++;
        }

        if (count < k) {
            return head;
        }

        ListNode pre = reverseKGroup(next, k);

        while (k-- > 0) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
}
