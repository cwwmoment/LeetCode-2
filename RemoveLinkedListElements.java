public class RemoveLinkedListElements {
	
	public static ListNode removeElements(ListNode head, int val) {
		if (head == null) {
			return null;
		}
		
		while (head.val == val) {
			if (head.next != null) {
				head = head.next;
			} else{
			    return null;
			}
		}
		
		ListNode tmp = head;
		ListNode dummy = tmp;

		while (tmp.next != null && tmp.next.next != null) {
			if (tmp.next.val == val) {
				tmp.next = tmp.next.next;
				continue;
			}
			tmp = tmp.next;
		}

		if (tmp.next.val == val) {
			tmp.next = null;
		}

		return dummy;
	}
	
    public static ListNode removeElements1(ListNode head, int val) {
    	if (head == null) return null;
    	
    	ListNode dummy = new ListNode(0);
    	dummy.next = head;
    	ListNode tmp = dummy;
    	
    	while(tmp.next != null) {
    		if (tmp.next.val == val) {
    			tmp.next = tmp.next.next; 
    		} else {
    			tmp = tmp.next;
    		}
    	}
    	
    	return dummy.next;
    }
}
