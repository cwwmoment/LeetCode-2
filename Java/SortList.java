/**
 * LeetCode #148. Sort List
 * 
 * Created by happygirlzt on 12 Sep 2018 at 12:01:30 PM
 *
 */
public class SortList {
	public ListNode sortList(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode fast = head;
		ListNode slow = head;
		ListNode pre = head;
		// find the mid position
		while (fast != null && fast.next != null) {
			pre = slow;
			slow = slow.next;
			fast = fast.next.next;
		}

		pre.next = null;
		
		ListNode l1 = sortList(head);
		ListNode l2 = sortList(slow);
		
		return merge(l1, l2);
	}
	
	public ListNode merge(ListNode l1, ListNode l2) {
		ListNode dummy = new ListNode(0);
		ListNode cur = dummy;
		
		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				cur.next = l1;
				l1 = l1.next;
			} else {
				cur.next = l2;
				l2 = l2.next;
			}
			
			cur = cur.next;
		}
		
		if (l1 != null) {
			cur.next = l1;
		}
		
		if (l2 != null) {
			cur.next = l2;
		}
		
		return dummy.next;
	}
}
