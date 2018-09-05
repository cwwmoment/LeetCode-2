/**
 * LeetCode #2. Add Two Numbers
 * 
 * Created by happygirlzt on 13 Jul 2018, modified on 5 Sep 2018
 *
 */

public class AddTwoNumbers {	
    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
       ListNode res = new ListNode(0);
       ListNode dummy = res;
       
       int cur = 0;
       while (l1 != null || l2 != null || cur != 0) { 
    	   int sum = ((l1 != null) ? l1.val : 0 ) + ((l2 != null) ? l2.val : 0); 
    	   
    	   int value = sum + cur;
           res.next = new ListNode(value % 10);
    	   res = res.next;
    	   cur = value / 10;
    	   
    	   if (l1 != null) {
    		   l1 = l1.next;
    	   }
    	   if (l2 != null) {
    		   l2 = l2.next;
    	   }
       }
       return dummy.next;
    }   
}