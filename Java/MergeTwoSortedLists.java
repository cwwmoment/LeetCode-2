/**
 * Created by happygirlzt on 14 Sep 2018
 *
 * LeetCode #21. Merge Two Sorted Lists
 */

public class MergeTwoSortedList {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode cur = new ListNode(0);
        ListNode dummy = cur;
        ListNode startL1 = l1;
        ListNode startL2 = l2;

        while (startL1 != null && startL2 != null) {
            if (startL1.val <= startL2.val) {
                cur.next = new ListNode(startL1.val);
                startL1 = startL1.next;
                cur = cur.next;
            } else {
                cur.next = new ListNode(startL2.val);
                startL2 = startL2.next;
                cur = cur.next;
            }
        }

        while (startL1 != null) {
            cur.next = new ListNode(startL1.val);
            startL1 = startL1.next;
            cur = cur.next;
        }

        while (startL2 != null) {
            cur.next = new ListNode(startL2.val);
            startL2 = startL2.next;
            cur = cur.next;
        }

        return dummy.next;
    }

    // Solution 2: Updated on 23 Jan 2019
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        PriorityQueue<ListNode> heap = new PriorityQueue<>((e1, e2) -> e1.val - e2.val);
        heap.offer(l1);
        heap.offer(l2);
        ListNode dummy = new ListNode(0);
        ListNode res = dummy;
        while (heap.size() > 0) {
            ListNode cur = heap.poll();
            res.next = new ListNode(cur.val);
            res = res.next;
            if (cur.next != null) {
                heap.offer(cur.next);
            }
        }

        return dummy.next;
    }
}
