/**
 * Created on 21 Sep 2018 by happygirlzt
 *
 * LeetCode #234. Palindrome Linked List
 */

public class PalindromeLinkedList {
    // My naive solution
    public boolean isPalindrome(ListNode head) {
        if (head == null) return false;

        // Reach the middle, traverse from beginning and middle to check
        int size = 0;
        ListNode fast = new ListNode(0);
        fast.next = head;
        ListNode slow = new ListNode(0);
        slow.next = head;

        ListNode first = new ListNode(0);
        first.next = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            size += 1;
        }

        if (fast == null) {  // odd
            slow = slow.next;

            while (slow != null) {
                for (int i = 0; i < size - 1; i++) {
                    first = first.next;
                }

                if (first.val != slow.val) {
                    return false;
                } else {
                    slow = slow.next;
                    first.next = head;
                    size--;
                }
            }

        } else {  // even
            if (slow.val != slow.next.val) {
                return false;
            } else {
                slow = slow.next.next;
            }

            while (slow != null) {
                for (int i = 0; i < size - 1; i++) {
                    first = first.next;
                }

                if (first.val != slow.val) {
                    return false;
                } else {
                    slow = slow.next;
                    first.next = head;
                    size--;
                }
            }
        }

        return true;
    }

    // Reverse
    public boolean isPalindrome1(ListNode head) {
        if (head == null) return true;
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        slow = reverse(slow);
        ListNode first = head;
        while (first != null) {
            if (first.val != slow.val) return false;
            first = first.next;
            slow = slow.next;
        }

        return true;
    }

    private ListNode reverse(ListNode slow) {
        ListNode pre = null;
        while (slow != null) {
            ListNode next = slow.next;
            slow.next = pre;
            pre = slow;
            slow = next;
        }

        return pre;
    }

    // Updated on 26 Feb 2019
    public boolean isPalindrome2(ListNode head) {
        if (head == null) return true;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }


        ListNode cur = slow.next;
        slow.next = null;
        ListNode prev = null;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        ListNode node = head;
        while (node != null && prev != null) {
            if (node.val != prev.val) return false;
            node = node.next;
            prev = prev.next;
        }

        return true;
    }
}
