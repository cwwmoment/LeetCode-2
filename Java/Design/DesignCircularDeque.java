/**
 * Created on 20 Jan 2019 by happygirlzt
 *
 * LeetCode #641. Design Circular Deque
 *
 */

class MyCircularDeque {
    class Node {
        Node prev;
        Node next;
        int val;
        public Node(int val) {
            this.val = val;
        }
    }

    int size;
    int k;
    Node head;
    Node tail;

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        head = new Node(-1);
        tail = new Node(-1);
        head.prev = tail;
        tail.next = head;
        this.k = k;
        this.size = 0;
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if (size == k) return false;
        Node node = new Node(value);
        node.next = head;
        node.prev = head.prev;
        head.prev.next = node;
        head.prev = node;
        size++;
        return true;
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if (size == k) return false;
        Node node = new Node(value);
        node.next = tail.next;
        tail.next.prev = node;
        tail.next = node;
        node.prev = tail;
        size++;
        return true;
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if (size == 0) return false;
        head.prev.prev.next = head;
        head.prev = head.prev.prev;
        size--;
        return true;
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if (size == 0) return false;
        tail.next.next.prev = tail;
        tail.next = tail.next.next;
        size--;
        return true;
    }

    /** Get the front item from the deque. */
    public int getFront() {
        return head.prev.val;
    }

    /** Get the last item from the deque. */
    public int getRear() {
        return tail.next.val;
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return size == 0;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return size == k;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */
