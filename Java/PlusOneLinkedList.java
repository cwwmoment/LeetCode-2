/**
 * Created on 26 Nov 2018 by happygirlzt
 *
 * LeetCode #369. Plus One Linked List
 *
 */

public class PlusOneLinkedList {
    public ListNode plusOne(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        helper(dummy);
        return dummy.val == 0 ? head : dummy;
    }

    private int helper(ListNode node) {
        if (node == null) return 1;
        node.val += helper(node.next);
        if (node.val <= 9) return 0;
        node.val %= 10;
        return 1;
    }
}
