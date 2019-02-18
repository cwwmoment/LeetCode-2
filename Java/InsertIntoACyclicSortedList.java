/**
 * Created on 18 Feb 2019 by happygirlzt
 * 
 * LeetCode #708. Insert into a Cyclic Sorted List
 */

class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val,Node _next) {
        val = _val;
        next = _next;
    }
};

 class Solution {
    public Node insert(Node head, int val) {
        if (head == null) {
            Node node = new Node();
            node.val = val;
            node.next = node;
            return node;
        }
        
        Node max = head;
        while (max.next != head && max.val <= max.next.val) {
            // the = is must, because there will be duplicates
            max = max.next;
        }
        
        Node min = max.next, cur = min;
        if (val <= min.val || val >= max.val) {
            Node node = new Node(val, min);
            max.next = node;
        } else {
            while (cur.next.val < val) {
                cur = cur.next;
            }
            
            Node node = new Node(val, cur.next);
            cur.next = node;
        }
        return head;
    }
 }