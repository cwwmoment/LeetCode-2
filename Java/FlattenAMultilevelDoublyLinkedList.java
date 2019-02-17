/**
 * Created on 17 Feb 2019 by happygirlzt
 * 
 * LeetCode #430. Flatten a Multilevel Doubly Linked List
 */
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;

    public Node() {}

    public Node(int _val,Node _prev,Node _next,Node _child) {
        val = _val;
        prev = _prev;
        next = _next;
        child = _child;
    }
};
class Solution {
    public Node flatten(Node head) {
        if (head == null) return head;
        Deque<Node> stack = new ArrayDeque<>();
        Node cur = head;
        while (cur != null) {
            if (cur.child != null) {
                if (cur.next != null) {
                    stack.push(cur.next);
                }
                
                cur.next = cur.child;
                if (cur.next != null) {
                    cur.next.prev = cur;
                }
                cur.child = null;
            } else if (cur.next == null && !stack.isEmpty()) {
                cur.next = stack.pop();
                if (cur.next != null) {
                    cur.next.prev = cur;
                }
            }
            
            cur = cur.next;
        }
        
        return head;
    }
}