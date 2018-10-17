import java.util.Arrays;

/**
 * LeetCode #23. Merge k Sorted Lists
 * 
 * @happygirlzt Created on 11 Aug 2018
 */

public class MergeKSortedLists {
	public class ListNode {
		int val;
		ListNode next;
		
		ListNode(int x) {
			val = x;
		}
	}

	public ListNode mergeKLists(ListNode[] lists) {
		if (lists == null || lists.length == 0)
			return null;

		int k = lists.length;
		ListNode dummy = new ListNode(0);
		ListNode res = dummy;
		int[] r = new int[50000];

		int count = 0;
		for (int i = 0; i < k; i++) {
			while (lists[i] != null) {
				r[count] = lists[i].val;
				count++;
				lists[i] = lists[i].next;
			}
		}

		int[] b = new int[count];

		System.arraycopy(r, 0, b, 0, count);
		Arrays.sort(b);

		for (int j = 0; j < count; j++) {
			ListNode tmp = new ListNode(b[j]);
			res.next = tmp;
			res = res.next;
		}

		return dummy.next;
	}

	// Solution 2
	private ListNode findMinAndMove(ListNode[] lists) {
		int min_value = Integer.MAX_VALUE;
		int ret_i = -1;
		for (int i = 0; i < lists.length; i++) {
			if (lists[i] == null) {
				continue;
			}

			if (lists[i].val < min_value) {
				min_value = lists[i].val;
				ret_i = i;
			}
		}

		ListNode ret_node = null;
		if (ret_i != -1) {
			ret_node = lists[ret_i];
			lists[ret_i] = lists[ret_i].next;
		}

		return ret_node;
	}

	public ListNode mergeKLists2(ListNode[] lists) {
		if (lists == null || lists.length == 0) {
			return null;
		}

		ListNode res = new ListNode(0);
		ListNode cur = res;
		ListNode tmp = null;

		while (tmp != null) {
			tmp = findMinAndMove(lists);
			cur.next = tmp;
			cur = cur.next;
		}

		return res.next;
	}

}
