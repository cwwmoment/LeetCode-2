/**
 * Created on 15 Oct 2018 by happygirlzt
 *
 * LeetCode #86. Partition List
 */

public class PartitionList {
    // 我的做法，能一次ac真的令人吃惊。。虽然这个代码写得很丑。。
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) return head;

        ListNode slow = head;
        ListNode fast = head.next;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode list = new ListNode(0);
        ListNode listDummy = list;

        boolean flag = false;
        if (slow.val >= x) {
            while (slow != null && fast != null) {
                if (slow.val >= x && fast.val >= x) {
                    fast = fast.next;
                    slow = slow.next;
                } else if (slow.val >= x && fast.val < x) {
                    list.next = new ListNode(fast.val);
                    list = list.next;
                    fast = fast.next;
                    slow.next = fast;
                }
            }
        } else {
            flag = true;
            while (slow != null && fast != null) {
                if (slow.val < x && fast.val < x) {
                    fast = fast.next;
                    slow = slow.next;
                } else if (slow.val < x && fast.val >= x) {
                    list.next = new ListNode(fast.val);
                    list = list.next;
                    fast = fast.next;
                    slow.next = fast;
                }
            }
        }

        if (flag) {
            slow.next = listDummy.next;
            return dummy.next;
        } else {
            list.next = head;
            return listDummy.next;
        }
    }

    // 别人的做法
    public ListNode partition1(ListNode head, int x) {
        ListNode dummy1 = new ListNode(0), dummy2 = new ListNode(0);
        ListNode curr1 = dummy1, curr2 = dummy2;
        while (head != null) {
            if (head.val < x) {
                curr1.next = head;
                curr1 = head;
            } else {
                curr2.next = head;
                curr2 = head;
            }

            head = head.next;
        }

        curr2.next = null;
        curr1.next = dummy2.next;
        return dummy1.next;
    }
}
