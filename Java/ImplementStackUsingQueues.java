/**
 * Created on 19 Sep 2018 by happygirlzt
 *
 * LeetCode #225. Implement Stack using Queues
 */
import java.util.Queue;
import java.util.LinkedList;

public class ImplementStackUsingQueues {
    class MyStack {

        private Queue<Integer> q1, q2;

        /** Initialize your data structure here. */
        public MyStack() {
            q1 = new LinkedList<>();
            q2 = new LinkedList<>();
        }

        /** Push element x onto stack. */
        public void push(int x) {
            if (q1.isEmpty() && q2.isEmpty()) {
                q1.offer(x);
            } else if (q1.isEmpty()) {
                q2.offer(x);
            } else {
                q1.offer(x);
                System.out.println(q1.size());
            }
        }

        /** Removes the element on top of the stack and returns that element. */
        public int pop() {
            if (q1.isEmpty() && q2.isEmpty()) {
                return -1;
            } else if (q1.isEmpty()) {
                // CRITICAL!!!!!!! q2.size() may change!!!!!
                int size = q2.size();
                for (int i = 0; i < size - 1; i++) {
                    q1.offer(q2.poll());
                }

                return q2.poll();
            } else {
                // CRITICAL!!!!!!! q1.size() may change!!!!!
                int size = q1.size();
                for (int i = 0; i < size - 1; i++) {
                    q2.offer(q1.poll());
                }

                return q1.poll();
            }
        }

        /** Get the top element. */
        public int top() {
            if (q1.isEmpty() && q2.isEmpty()) {
                return -1;
            } else if (q1.isEmpty()) {
                // CRITICAL!!!!!!! q2.size() may change!!!!!
                int size = q2.size();
                for (int i = 0; i < size - 1; i++) {
                    q1.offer(q2.poll());
                }

                int top = q2.peek();
                q1.offer(top);
                return q2.poll();
            } else {
                // CRITICAL!!!!!!! q1.size() may change!!!!!
                int size = q1.size();
                for (int i = 0; i < size - 1; i++) {
                    q2.offer(q1.poll());
                }

                int top =  q1.peek();
                q2.offer(top);
                return q1.poll();
            }
        }

        /** Returns whether the stack is empty. */
        public boolean empty() {
            return (q1.isEmpty() && q2.isEmpty());
        }
    }

    /**
     * Your MyStack object will be instantiated and called as such:
     * MyStack obj = new MyStack();
     * obj.push(x);
     * int param_2 = obj.pop();
     * int param_3 = obj.top();
     * boolean param_4 = obj.empty();
     */
}

// Updated on 26 Jan 2019
class MyStack {

    Queue<Integer> q1;
    Queue<Integer> q2;
    /** Initialize your data structure here. */
    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        if (q1.size() != 0) {
            q1.offer(x);
        } else {
            q2.offer(x);
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    /*
      q1: 5 4
      q2: 5
    */
    public int pop() {
        if (q1.isEmpty() && q2.isEmpty()) return -1;

        if (q1.isEmpty()) {
            while (q2.size() > 1) {
                q1.offer(q2.poll());
            }
            return q2.poll();
        } else {
            while (q1.size() > 1) {
                q2.offer(q1.poll());
            }
            return q1.poll();
        }
    }

    /** Get the top element. */
    public int top() {
        if (q1.isEmpty() && q2.isEmpty()) return -1;
        int res = 0;
        if (q1.isEmpty()) {
            while (!q2.isEmpty()) {
                res = q2.poll();
                q1.offer(res);
            }
        } else {
            while (!q1.isEmpty()) {
                res = q1.poll();
                q2.offer(res);
            }
        }

        return res;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q1.isEmpty() && q2.isEmpty();
    }
}
/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
