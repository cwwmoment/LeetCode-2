/**
 * Created on 3 Jan 2019 by happygirlzt
 *
 * LeetCode #281. Zigzag Iterator
 *
 */

public class ZigzagIterator {
    private int i, j;
    private List<Integer> v1, v2;

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        i = 0;
        j = 0;
        this.v1 = v1;
        this.v2 = v2;
    }

    public int next() {
        int res = -1;
        if (i == j && i < v1.size()) {
            res = v1.get(i);
            i++;
            return res;
        }

        if (i > j && j < v2.size()) {
            res = v2.get(j);
            j++;
            return res;
        }

        if (i >= v1.size() - 1 && j < v2.size()) {
            res = v2.get(j);
            j++;
            return res;
        }

        if (j >= v2.size() - 1 && i < v1.size()) {
            res = v1.get(i);
            i++;
            return res;
        }

        return -1;
    }

    public boolean hasNext() {
        if (i >= v1.size() && j >= v2.size()) {
            return false;
        } else {
            return true;
        }
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */
