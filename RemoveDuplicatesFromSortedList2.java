/**
 * Created on 15 Oct 2018 by happygirlzt
 *
 * LeetCode #82. Remove Duplicates from Sorted List II
 */

public class RemoveDuplicatesFromSortedList2 {
    // 我的愚蠢的代码
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;

        HashSet<Integer> set = new HashSet<>();
        ListNode dummy = new ListNode(0);
        ListNode res = dummy;
        ListNode slow = head;

        int tmp = Integer.MAX_VALUE;
        int s = 0;
        while (slow != null) {
            if (set.contains(slow.val)) {
                set.remove(slow.val);
                tmp = slow.val;
            } else if (slow.val != tmp) {
                set.add(slow.val);
                tmp = slow.val;
            }

            slow = slow.next;
            s++;
        }

        if (s == set.size()) return head;

        int[] arr = new int[set.size()];
        int j = 0;
        for (int i : set) {
            arr[j++] = i;
        }

        Arrays.sort(arr);
        for (int i : arr) {
            dummy.next = new ListNode(i);
            dummy = dummy.next;
        }

        return res.next;
    }

    // Other's smart solution
    public ListNode deleteDuplicates1(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode f = new ListNode(0);
        f.next = head;
        ListNode prev = f;
        ListNode curr = head;

        while (curr != null) {
            while (curr.next != null && curr.val == curr.next.val) {
                curr = curr.next;
            }

            if (prev.next == curr)
                prev = prev.next;
            else
                prev.next = curr.next;

            curr = curr.next;
        }

        return f.next;
    }
}
