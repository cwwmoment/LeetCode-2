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
