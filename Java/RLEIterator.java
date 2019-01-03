/**
 * Created on 3 Jan 2019 by happygirlzt
 *
 * LeetCode #900. RLE Iterator
 *
 */

class RLEIterator {
    private int[] a;
    private int index;
    public RLEIterator(int[] A) {
        index = 0;
        this.a = A;
    }

    public int next(int n) {
        while (index < a.length && n > a[index]) {
            n -= a[index];
            index += 2;
        }

        if (index >= a.length) return -1;

        a[index] -= n;
        return a[index + 1];
    }
}

/**
 * Your RLEIterator object will be instantiated and called as such:
 * RLEIterator obj = new RLEIterator(A);
 * int param_1 = obj.next(n);
 */
