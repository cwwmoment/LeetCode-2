import java.util.Stack;

/**
 * 445. Add Two Numbers II
 *
 * Created by happygirlzt modified on 4 Sep 2018 at 10:05:57 PM
 *
 */
public class AddTwoNumber2 {
    // My naive solution
	public void display(ListNode l) {
		while (l != null) {
			System.out.print(l.val + " -> ");
			l = l.next;
		}
		System.out.println(l);
	}

	public int getLength(ListNode l) {
		int count = 0;

		while (l != null) {
			l = l.next;
			count++;
		}

		return count;
	}

	// Java can't return array by return the name

	public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
		int length_1 = getLength(l1);
		int length_2 = getLength(l2);

		ListNode tmp = new ListNode(0);
		ListNode dummy = tmp;

		// How to assign values correctly? Attention!

		// int length_res = (length_1 > length_2 ? length_1 : length_2);
		// int[] res = new int[length_res + 1];

		int[] res;

		if (length_1 == length_2) {
			int[] a1 = new int[length_1];
			int[] a2 = new int[length_2];

			res = new int[length_1 + 1];

			for (int k = 0; k < length_1; k++) {
				a1[k] = l1.val;
				l1 = l1.next;

				a2[k] = l2.val;
				l2 = l2.next;

				res[k + 1] = a1[k] + a2[k];
				System.out.print(res[k] + " == ");
			}

			System.out.println(res[length_1]);
			for (int m = length_1; m > 0; m--) {
				if (res[m] >= 10) {

					// System.out.println(res[m]);
					res[m] = res[m] % 10;
					res[m - 1] += 1;
				}
				System.out.println(res[m] + " is " + m + "th one");
			}
			if (res[1] > 10) {
				res[1] = res[1] % 10;
				res[0] = res[1] / 10;
			}
			System.out.print(res[0] + " is 0th one");

		} else if (length_1 > length_2) {
			int resLen = length_1 + 1;

			res = new int[resLen];

			int[] a1 = new int[length_1];
			int[] a2 = new int[length_1];

			for (int i = 0; i < length_1; i++) {
				a1[i] = l1.val;
				l1 = l1.next;

				if (i >= length_1 - length_2) {
					a2[i] = l2.val;
					l2 = l2.next;
				} else {
					a2[i] = 0;
				}

				res[i + 1] = a1[i] + a2[i];
				System.out.print(res[i] + " == ");
			}

			System.out.println(res[resLen - 1]);

			for (int m = resLen - 1; m > 0; m--) {
				if (res[m] >= 10) {

					// System.out.println(res[m]);
					res[m] = res[m] % 10;
					res[m - 1] += 1;
				}

				System.out.println(res[m] + " is " + m + "th one");
			}
			System.out.print(res[0] + " is 0th one");
		} else {
			int resLen = length_2 + 1;

			res = new int[resLen];

			int[] a1 = new int[length_2];
			int[] a2 = new int[length_2];

			for (int i = 0; i < length_2; i++) {
				a2[i] = l2.val;
				l2 = l2.next;

				if (i >= length_2 - length_1) {
					a1[i] = l1.val;
					l1 = l1.next;
				} else {
					a1[i] = 0;
				}

				res[i + 1] = a1[i] + a2[i];
				System.out.print(res[i] + " == ");
			}

			System.out.println(res[resLen - 1]);

			for (int m = resLen - 1; m > 0; m--) {
				if (res[m] >= 10) {

					// System.out.println(res[m]);
					res[m] = res[m] % 10;
					res[m - 1] += 1;
				}

				System.out.println(res[m] + " is " + m + "th one");
			}
			if (res[1] > 10) {
				res[1] = res[1] % 10;
				res[0] = res[1] / 10;
			}
			System.out.print(res[0] + " is 0th one");
		}

		if (res[0] != 0) {
			for (int i = 0; i < res.length; i++) {
				tmp.next = new ListNode(0);
				tmp.next.val = res[i];
				tmp = tmp.next;
			}

			return dummy.next;
		} else {
			for (int i = 1; i < res.length; i++) {
				tmp.next = new ListNode(0);
				tmp.next.val = res[i];
				tmp = tmp.next;
			}
			return dummy.next;
		}
	}
	// return res;


	// Using stack
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		Stack<ListNode> st1 = new Stack<ListNode>();
		Stack<ListNode> st2 = new Stack<ListNode>();
		Stack<ListNode> result = new Stack<ListNode>();
		
		ListNode dummy = new ListNode(0);
		ListNode cur = dummy;
		
		while(l1 != null) {
			st1.push(new ListNode(l1.val));
			l1 = l1.next;
		}
		
		while(l2 != null) {
			st2.push(new ListNode(l2.val));
			l2 = l2.next;
		}
		
		int sum = 0;
		
		while (!st1.empty() || !st2.empty()) {
			
		    if (!st1.empty()) sum += st1.pop().val;
		    
		    if (!st2.empty()) sum += st2.pop().val;
		    
		    result.push(new ListNode(sum % 10));
		    
		    sum = sum / 10;
		}
		
		if (sum == 1)
			result.push(new ListNode(1));
		
		while (!result.empty()) {
			cur.next = result.pop();
			cur = cur.next;
		}
		
		return dummy.next;
	}
	
	public static void main(String[] args) {
		AddTwoNumber2 a = new AddTwoNumber2();

		ListNode L1 = new ListNode(7);
		L1.next = new ListNode(2);
		L1.next.next = new ListNode(4);
		L1.next.next.next = new ListNode(3);

		a.display(L1);

		ListNode L2 = new ListNode(5);
		L2.next = new ListNode(6);
		L2.next.next = new ListNode(4);

		a.display(L2);

		// a.addTwoNumbers2(L1, L2);
		ListNode result = a.addTwoNumbers2(L1, L2);
		a.display(result);
	}
}
