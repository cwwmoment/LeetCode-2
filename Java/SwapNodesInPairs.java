/**
* Created on 8 Feb 2019 by happygirlzt
* LeetCode #24. Swap Nodes in Pairs
*/

class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null) {
            ListNode first = cur.next;
            ListNode second = cur.next.next;
            cur.next = second;
            first.next = second.next;
            second.next = first;
            cur = first;
        }
        return dummy.next;
    }
}