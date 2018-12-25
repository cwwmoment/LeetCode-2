/**
 * Created on 25 Dec 2018 by happygirlzt
 *
 * LeetCode #143. Reorder List
 *
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;

        ListNode slow = head;
        ListNode fast = head;
        // find mid
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode preMid = slow;
        ListNode cur = slow.next;
        // 1 ->2 ->3 ->4 ->5
        // 1 ->2 ->5 ->4 ->3
        while (cur.next != null) {
            ListNode next = cur.next;
            cur.next = next.next;
            next.next = preMid.next;
            preMid.next = next;
        }

        slow = head;
        fast = preMid.next;
        while (slow != preMid) {
            preMid.next = fast.next;
            fast.next = slow.next;
            slow.next = fast;
            slow = fast.next;
            fast = preMid.next;
        }
    }
}
