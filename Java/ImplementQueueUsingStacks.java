/**
 * Created on 19 Sep 2018 by happygirlzt
 *
 * LeetCode #232. Implement Queue using Stacks
 */

import java.util.Stack;

public class ImplementQueueUsingStacks {
    class MyQueue {

        private Stack<Integer> s1, s2;

        /** Initialize your data structure here. */
        public MyQueue() {
            s1 = new Stack<>();
            s2 = new Stack<>();
        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            s1.push(x);
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            if (s1.isEmpty()) {
                return -1;
            } else {
                int size = s1.size();
                for (int i = 0; i < size - 1; i++) {
                    s2.push(s1.pop());
                }

                int tmp = s1.pop();
                int len = s2.size();
                for (int i = 0; i < len; i++) {
                    s1.push(s2.pop());
                }

                return tmp;
            }
        }

        /** Get the front element. */
        public int peek() {
            if (s1.isEmpty()) {
                return -1;
            } else {
                int size = s1.size();
                for (int i = 0; i < size - 1; i++) {
                    s2.push(s1.pop());
                }

                int tmp = s1.peek();
                int len = s2.size();
                for (int i = 0; i < len; i++) {
                    s1.push(s2.pop());
                }

                return tmp;
            }
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            return s1.isEmpty();
        }
    }
}

// Updated on 26 Jan 2019
class MyQueue {
    Deque<Integer> s1;
    Deque<Integer> s2;
    private int front;  // Use a front element
    /** Initialize your data structure here. */
    public MyQueue() {
        s1 = new ArrayDeque<>();
        s2 = new ArrayDeque<>();
    }

    /*
      6 3 9

     */
    /** Push element x to the back of queue. */
    public void push(int x) {
        if (s1.isEmpty()) {
            front = x;
        }
        s1.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (s1.isEmpty()) return -1;
        int res = 0;
        while (s1.size() > 1) {
            s2.push(s1.pop());
        }
        res = s1.pop();
        if (!s2.isEmpty()) front = s2.peek();
        while (s2.size() > 0) {
            s1.push(s2.pop());
        }
        return res;
    }

    /** Get the front element. */
    public int peek() {
        return front;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return s1.isEmpty();
    }
}
