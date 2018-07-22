class RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode modified = new ListNode(0);
        modified = head;

        while (modified != null) {
            if (modified.next == null)
                break;
            if (modified.val == modified.next.val) {
                modified.next = modified.next.next;
            } else {
                modified = modified.next;
            }
        }

        return dummy.next;
    }


    public ListNode deleteDuplicates(ListNode head) {
        // ListNode dummy = new ListNode(0);
        // dummy.next = head;
        // if (head == null)
        //    return head;

        ListNode modified = new ListNode(0);
        modified = head;

        while(modified.next != null && modified.next != null) {
            if (modified.val == modified.next.val) {
                modified.next = modified.next.next;
            } else {
                modified = modified.next;
            }
        }

        // return dummy.next;
        return head;
    }
}
