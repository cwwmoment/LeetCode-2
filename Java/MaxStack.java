/**
 * Created on 31 Dec 2018 by happygirlzt
 *
 * LeetCode #716. Max Stack
 *
 */

class MaxStack {
    Deque<Integer> st;
    Deque<Integer> maxSt;

    /** initialize your data structure here. */
    public MaxStack() {
        st = new ArrayDeque();
        maxSt = new ArrayDeque();
    }

    public void push(int x) {
        int max = maxSt.isEmpty() ? x : maxSt.peek();
        maxSt.push(max > x ? max : x);
        st.push(x);
    }

    public int pop() {
        maxSt.pop();
        return st.pop();
    }

    public int top() {
        return st.peek();
    }

    public int peekMax() {
        return maxSt.peek();
    }

    public int popMax() {
        int max = peekMax();
        Deque<Integer> buffer = new ArrayDeque();
        while (top() != max) {
            buffer.push(pop());
        }

        pop();
        while (!buffer.isEmpty()) {
            push(buffer.pop());
        }

        return max;
    }
}

/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack obj = new MaxStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();
 */

class MaxStack {
    class Node {
        int val;
        Node next;
        Node prev;
        public Node(int v) {
            val = v;
            prev = null;
            next = null;
        }
    }

    Node head;
    Node maxHead;
    public MaxStack() {
        head = null;
        maxHead = null;
    }

    public void push(int x) {
        Node n = new Node(x);
        if (head == null) {
            head = n;
            maxHead = n;
        } else {
            n.next = head;
            head.prev = n;
            head = n;
            if (n.val >= maxHead.val) {
                maxHead = n;
            }
        }
    }

    public int pop() {
        int val = head.val;
        if (head == maxHead) {
            Node cur = head.next;
            maxHead = cur;
            while (cur != null) {
                if (cur.val > maxHead.val) {
                    maxHead = cur;
                }
                cur = cur.next;
            }
        }

        head = head.next;
        if (head != null) {
            head.prev = null;
        }

        return val;
    }

    public int top() {
        return head.val;
    }

    public int peekMax() {
        return maxHead.val;
    }

    public int popMax() {
        int val = maxHead.val;

        if (head == maxHead) {
            head = head.next;
            if (head != null) {
                head.prev = null;
            }
        } else {
            if (maxHead.next != null) {
                maxHead.next.prev = maxHead.prev;
            }

            if (maxHead.prev != null) {
                maxHead.prev.next = maxHead.next;
            }
        }

        Node cur = head;
        maxHead = cur;
        while (cur != null) {
            if (cur.val > maxHead.val) {
                maxHead = cur;
            }
            cur = cur.next;
        }

        return val;
    }
}
