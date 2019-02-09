/**
 * Created on 9 Feb 2019 by happygirlzt
 *
 * LeetCode #223. Rectangle Area
 *
 */

class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int abcd = (D - B) * (C - A);
        int efgh = (H - F) * (G - E);
        int overlap = overlapped(A, B, C, D, E, F, G, H);
        return abcd + efgh - overlap;
    }
    
    private int overlapped(int A, int B, int C, int D, int E, int F, int G, int H) {
        int left = Math.max(A, E);
        int right = Math.min(C, G);
        int high = Math.min(D, H);
        int low = Math.max(B, F);
        if (left >= right || low >= high) return 0;
        return (right - left) * (high - low);
    }
}