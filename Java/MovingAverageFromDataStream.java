/**
 * Created on 22 Nov 2018 by happygirlzt
 *
 * LeetCode #346. Moving Average from Data Stream
 *
 */

class MovingAverage {

    private Queue<Integer> q;
    private int cap;
    private int sum;

    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        cap = size;
        sum = 0;
        q = new LinkedList<>();
    }

    public double next(int val) {
        if (q.size() < cap) {
            q.offer(val);
            sum += val;
            return (double) sum / (double) q.size();
        } else {
            sum -= q.poll();
            q.offer(val);
            sum += val;
            return (double) sum / (double) cap;
        }
    }
}
