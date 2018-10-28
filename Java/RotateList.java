/**
 * Created on 28 Oct 2018 by happygirlzt
 *
 * LeetCode #61. Rotate List
 *
 */

public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode fast = dummy. slow = dummy;

        int i;
        // Get the length
        for (i = 0; fast.next != null; i++) {
            fast = fast.next;
        }

        for (int j = i - n % i; j > 0; j--) {
            slow = slow.next;
        }

        fast.next = dummy.next;
        dummy.next = slow.next;
        slow.next = null;

        return dummy.next;
    }
}
