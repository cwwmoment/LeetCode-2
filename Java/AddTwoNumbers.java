/**
 * LeetCode #2. Add Two Numbers
 *
 * Created by happygirlzt on 13 Jul 2018, modified on 5 Sep 2018
 *
 */

public class AddTwoNumbers {
    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        ListNode dummy = res;

        int cur = 0;
        while (l1 != null || l2 != null || cur != 0) {
            int sum = ((l1 != null) ? l1.val : 0 ) + ((l2 != null) ? l2.val : 0);

            int value = sum + cur;
            res.next = new ListNode(value % 10);
            res = res.next;
            cur = value / 10;

            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        return dummy.next;
    }

    // Updated on 30 Jan
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode dummy = new ListNode(0);
        ListNode res = dummy;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int sum = carry;
            sum += (l1 == null) ? 0 : l1.val;
            sum += (l2 == null) ? 0 : l2.val;
            res.next = new ListNode(sum % 10);
            res = res.next;
            carry = sum / 10;
            l1 = (l1 == null) ? null : l1.next;
            l2 = (l2 == null) ? null : l2.next;
        }

        if (carry > 0) {
            res.next = new ListNode(carry);
            res = res.next;
        }

        return dummy.next;
    }
}
