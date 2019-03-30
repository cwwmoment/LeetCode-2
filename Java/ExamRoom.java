/**
 * Created on 30 Mar 2019 by happygirlzt
 *
 * LeetCode #855. Exam Room
 *
 */

class ExamRoom {
    private TreeSet<Integer> occupied;
    private int N;
    public ExamRoom(int N) {
        this.N = N;
        occupied = new TreeSet<>();
    }

    public int seat() {
        int pos = 0;
        if (occupied.size() > 0) {
            Integer prev = null;
            int dist = occupied.first() - 0;
            for (Integer p : occupied) {
                if (prev != null) {
                    int d = (p - prev) / 2;
                    if (d > dist) {
                        dist = d;
                        pos = prev + d;
                    }
                }

                prev = p;
            }

            if (N - 1 - occupied.last() > dist) {
                pos = N - 1;
            }
        }

        occupied.add(pos);
        return pos;
    }

    public void leave(int p) {
        occupied.remove(p);
    }
}

/**
 * Your ExamRoom object will be instantiated and called as such:
 * ExamRoom obj = new ExamRoom(N);
 * int param_1 = obj.seat();
 * obj.leave(p);
 */
