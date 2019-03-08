/**
 * Created on 31 Dec 2018 by happygirlzt
 *
 * LeetCode #528. Random Pick with Weight
 *
 */

// e.g.: [1, 3]
// [1, 3, 3, 3]
// Find the smallest element greater than index
class Solution {

    private int range;
    private int[] weights;
    private Random random;
    public Solution(int[] w) {
        weights = new int[w.length];
        random = new Random();
        for (int i = 0; i < w.length; i++) {
            range += w[i];
            weights[i] = range;
        }
    }

    public int pickIndex() {
        // We should + 1, as the start weight is 1
        int index = random.nextInt(weights[weights.length - 1]) + 1;
        int lo = 0;
        int hi = weights.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (weights[mid] < index) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }

        return lo;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
