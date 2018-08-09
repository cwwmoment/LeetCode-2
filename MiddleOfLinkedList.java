/*
 * LeetCode #876. Middle of the Linked List
 * happygirlzt
 * Created on 8 Aug 2018
 */

public class MiddleOfLinkedList {
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int v) {
			val = v;
		}
	}
	
	public ListNode middleNode(ListNode head) {
		if (head == null) return null;
		
		ListNode tmp = head;
		ListNode dummy = null;
		dummy.next = tmp;
		
		int count = 1;
		
		while (tmp.next != null) {
			tmp = tmp.next;
			count ++;
		}
		
		int mid = count / 2;
		while (mid != 0) {
			mid --;
			dummy = dummy.next;
		}
		
		return dummy;
	}
	
}
