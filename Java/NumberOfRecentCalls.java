/**
 * Created on 19 Mar 2019 by happygirlzt
 *
 * LeetCode #933. Number of Recent Calls
 *
 */

class RecentCounter {

    private Queue<Integer> q;
    public RecentCounter() {
        q = new LinkedList<>();
    }

    public int ping(int t) {
        q.offer(t);
        if (q.size() == 1) return 1;
        while (!q.isEmpty() && t - q.peek() > 3000) q.poll();
        return q.size();
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */
