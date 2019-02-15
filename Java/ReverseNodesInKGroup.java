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

    // Updated on 15 Feb 2019
    public ListNode reverseKGroup1(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode first = dummy.next;
        ListNode last = dummy.next;
        ListNode preHead = null;
        while (true) {
           for (int i = 0; i < k; i++) {
               if (last == null) return dummy.next;           
               last = last.next;
           }

           ListNode newHead = reverse(first, last);
           if (preHead == null) dummy.next = newHead;
           else preHead.next = newHead;

           preHead = first;
           first = last;
        }
  }

   private ListNode reverse(ListNode head, ListNode tail) {
       ListNode cur = head;
       ListNode prev = tail;
       while (cur != tail) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
       }

       return prev;
    }
}
