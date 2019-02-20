/**
 * Created on 20 Feb 2019 by happygirlzt
 * 
 * LeetCode #622. Design Circular Queue
 */

 // 1. Take advantage of reminder
 // 2. Take care of the edge cases, when the q is empty or full
 // firstlt, check
class MyCircularQueue {

    private int[] q;
    private int size;
    private int head;
    private int tail;
    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        q = new int[k];
        size = k;
        head = -1;
        tail = -1;
    }
    
    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if (isFull()) return false;
        if (tail == -1) {
            head = 0;
        }
        
        tail = (tail + 1) % size;
        q[tail] = value;
        return true;
    }
    
    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if (isEmpty()) return false;
        
        if (head == tail && head != -1) {
            head = -1;
            tail = -1;
        } else head = (head + 1) % size;
        return true;
    }
    
    /** Get the front item from the queue. */
    public int Front() {
        if (isEmpty()) return -1;
        return q[head];
    }
    
    /** Get the last item from the queue. */
    public int Rear() {
        if (isEmpty()) return -1;
        return q[tail];
    }
    
    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return head == -1 && tail == -1;
    }
    
    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        // return (tail - head + 1) % size == 0;
        return (tail + 1) % size == head;
    }
}