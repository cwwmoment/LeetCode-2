public class AddTwoNumbers {
	
    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
		ListNode cur = dummy;
		
		int carry = 0;
		while (l1 != null || l2 != null || carry == 1) {
			int sum = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0);
			
			int value = sum + carry;
			
			cur.next = new ListNode(value % 10);
			
			carry = value / 10;
			if (l1 != null) l1 = l1.next;
			if (l2 != null) l2 = l2.next;
			cur = cur.next;
		}
		
		return dummy.next;
    }   
}