/**
 * LeetCode #142. Linked List Cycle2
 * 
 * Created by happygirlzt on 6 Sep 2018 at 9:14:58 AM
 *
 */
public class LinkedListCycle2 {
	public ListNode detectCycle(ListNode head) {
		if (head == null)
			return head;
		
		ListNode slow = head;
		ListNode fast = slow;

		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;

			if (fast == slow) {
				ListNode slow2 = head;
				while (slow2 != slow) {
					slow = slow.next;
					slow2 = slow2.next;
				}
				return slow;
			}
		}
		return null;
	}

	// more concise
	public ListNode detectCycle2(ListNode head) {
		if (head == null) {
			return null;
		}
		
		ListNode slow = head;
		ListNode fast = head.next;

		while (slow != fast) {
			if (fast == null || fast.next == null) {
				return null;  // have no cycle
			}
			slow = slow.next;
			fast = fast.next.next;
		}

		slow = head;
		fast = fast.next;
		while (slow != fast) {
			slow = slow.next;
			fast = fast.next;
		}
		return slow;
	}
}