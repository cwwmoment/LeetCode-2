/**
 * Created on 10 Jan 2019 by happygirlzt
 *
 * LeetCode #817. Linked List Components
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
    public int numComponents(ListNode head, int[] G) {
        Set<Integer> set = new HashSet<>();
        for (int i : G) {
            set.add(i);
        }
        int res = 0;
        ListNode cur = head;
        while (cur != null) {
            if (set.contains(cur.val) && (cur.next == null ||
                                          !set.contains(cur.next.val))) {
                res++;
            }

            cur = cur.next;
        }

        return res;
    }

    // Updated on 25 Mar 2019
    // Time: O(max(n, m))
    // Space: O(n)
    public int numComponents1(ListNode head, int[] G) {
        Set<Integer> set = new HashSet<>();
        for (int i : G) {
            set.add(i);
        }
        int count = 0;
        ListNode node = head;
        boolean prevInSet = false;
        while (node != null) {
            if (set.contains(node.val)) {
                set.remove(node.val);
                if (!prevInSet) {
                    count++;
                    prevInSet = true;
                }
            } else {
                prevInSet = false;
            }
            node = node.next;
        }

        return count;
    }
}
