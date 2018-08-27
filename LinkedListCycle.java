/**
 * LeetCode # 141. Linked List Cycle
 * 
 * Created on 2018-08-27
 * 
 * @author happygirlzt
 *
 */

public class LinkedListCycle {
	public boolean hasCycle(ListNode head) {
		if (head == null)
			return false;

		ListNode fast = head;
		ListNode slow = head;

		while (fast.next != null) {
			if (fast.next.next != null) {
				slow = slow.next;
				fast = fast.next.next;
			} else {
				return false;
			}
			
			if (slow.next == fast.next) {
				return true;
			}
		}
		
		return false;
	}
}
