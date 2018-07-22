// Solution 1
class RemoveNthNodeFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null)
            return head;

        ListNode newNode = head;
        int count = 1;
        while(newNode.next != null) {
            count++;
            newNode = newNode.next;
        }

        int pos = count - n;

        ListNode tmpNode = head;

        int c = 0;
        while(c < pos) {
            tmpNode = tmpNode.next;
            c++;
        }
        ListNode current = tmpNode;
        tmpNode.next = current.next;

        current.next = null;
        return head;
    }
}

// Solution 2
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null)
            return head;

        ListNode dummy = new ListNode(0);

        dummy.next = head;

        ListNode slow = dummy;
        ListNode fast = dummy;

        // fast moves first
        while(n != 0) {
            fast = fast.next;
            n--;
        }

        // move together
        while(fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;

        return dummy.next;
    }
}
