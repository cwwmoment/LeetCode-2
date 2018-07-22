import java.util.Stack;

public class AddTwoNumber2Stack {
	public static class ListNode {
		int val;
		ListNode next;

		public ListNode(int v) {
			val = v;
			next = null;
		}
	}

	public void display(ListNode l) {
    	while(l != null) {
    		System.out.print(l.val + " -> ");
    		l = l.next;
    	}
    	System.out.println(l);
    }
	
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
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
		
		while(!st1.empty() || !st2.empty()) {
			
		    if (!st1.empty()) sum += st1.pop().val;
		    // System.out.println("Added l1 " + sum);
		    
		    if (!st2.empty()) sum += st2.pop().val;
		    // System.out.println("l1 + l2 " + sum);
		    
		    // sum = sum % 10;
		    // System.out.println("Result " + sum);
		    result.push(new ListNode(sum % 10));
		    
		    sum = sum / 10;
		    // System.out.println("Clear sum " + sum);
		}
		
		if (sum == 1)
			result.push(new ListNode(1));
		
		while(!result.empty()) {
			cur.next = result.pop();
			cur = cur.next;
		}
		
		return dummy.next;
	}

	public static void main(String[] args) {
		AddTwoNumber2Stack a = new AddTwoNumber2Stack();
		
		ListNode l1 = new ListNode(7);
		l1.next = new ListNode(2);
		l1.next.next = new ListNode(4);
		l1.next.next.next = new ListNode(3);
		
		a.display(l1);
	
		ListNode l2 = new ListNode(5);
		l2.next = new ListNode(6);
		l2.next.next = new ListNode(4);
		
		a.display(l2);
		
		ListNode res = a.addTwoNumbers(l1, l2);
		a.display(res);
		
	}
}
