/**
 * Created on 31 Dec 2018 by happygirlzt
 *
 * LeetCode #528. Random Pick with Weight
 *
 */

class Solution {
    int[] ws;
    int max;
    public Solution(int[] w) {
        max = 0;
        ws = new int[w.length];

        for(int i = 0; i < ws.length; i++){
            max += w[i];
            ws[i] = max;
        }
    }

    public int pickIndex() {
        int random = (int)(Math.random() * (max) + 1);
        int l = 0, r = ws.length - 1;
        while (l < r ) {
            int m = l + (r - l) / 2;
            if (ws[m] < random) {
                l = m + 1;
            } else {
                r = m;
            }
        }

        return l;
    }
}
