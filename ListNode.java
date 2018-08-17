/*
 * happygirlzt
 * Created on 17 Aug 2018
 */
public class ListNode {
	int val;
	ListNode next;
	
	ListNode(int x) {
		val = x;
	}
	
	public void display(ListNode l) {
    	while(l != null) {
    		System.out.print(l.val + " -> ");
    		l = l.next;
    	}
    	System.out.println(l);
    }
}