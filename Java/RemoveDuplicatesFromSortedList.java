/*
 * LeetCode #83. Remove Duplicates from Sorted List
 * happygirlzt
 * Created on 16 July 2018
 */

class RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {

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

        return head;
    }


    public ListNode deleteDuplicates2(ListNode head) {
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
    
    public ListNode deleteDuplicates3(ListNode head) {
    	if (head == null || head.next == null) return head;
    	
    	head.next = deleteDuplicates3(head.next);
    	return head.next.val == head.val ? head.next : head;
    } 
}
