/**
 * Created on 21 Sep 2018 by happygirlzt
 *
 * LeetCode #160. Intersection of Two Linked Lists
 */

import java.util.HashSet;

public class IntersectionOfTwoLinkedLists {
    // 不合格的做法，我的这个做法的space complexity是O(n)
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;

        HashSet<ListNode> set = new HashSet<>();

        ListNode first = new ListNode(0);
        first.next = headA;
        ListNode sec = new ListNode(0);
        sec.next = headB;

        // Traverse ListNode A
        while (first != null) {
            set.add(first);
            first = first.next;
        }

        // Traverse ListNode B
        while (sec != null) {
            if (set.contains(sec)) {
                return sec;
            } else {
                sec = sec.next;
            }
        }

        return null;
    }

    // Other's smart solution
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;

        ListNode a = headA;
        ListNode b = headB;

        while (a != b) {
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }

        return a;
    }
}
