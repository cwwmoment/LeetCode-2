/**
 * LeetCode #109. Convert Sorted List to Binary Search Tree
 *
 * Created on 2018-08-27
 *
 * @author happygirlzt
 *
 */
import java.util.LinkedList;

public class ConvertSortedList2BinarySearchTree {
    // slow solution
    public TreeNode sortedListToBST1(ListNode head) {
        if (head == null) return null;
        LinkedList<Integer> list = new LinkedList<>();

        while (head != null) {
            list.add(head.val);
            head = head.next;
        }

        return helper(list, 0, list.size() - 1);
    }

    public TreeNode helper(LinkedList<Integer> list, int left, int right) {
        if (left > right) return null;

        int mid = (left + right) >> 1;
        TreeNode root = new TreeNode(list.get(mid));

        root.left = helper(list, left, mid - 1);
        root.right = helper(list, mid + 1, right);

        return root;
    }

    // updated on 13 Jan 2019
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        ListNode mid = helper(head);
        TreeNode root = new TreeNode(mid.val);
        // base case
        if (head == mid) return root;

        root.left = sortedListToBST(head);
        root.right = sortedListToBST(mid.next);

        return root;
    }

    // Find the mid of the list
    private ListNode helper(ListNode head) {
        ListNode pre = null;
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        if (pre != null) {
            pre.next = null;
        }

        return slow;
    }
}
