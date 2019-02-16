/**
 * Created on 16 Feb 2019 by happygirlzt
 * 
 * LeetCode #255. Verify Preorder Sequence in Binary Search Tree
 * 
 */

class Solution {
    public boolean verifyPreorder(int[] preorder) {
        int low = Integer.MIN_VALUE, i = -1;
        for (int p : preorder) {
            if (p < low) return false;
            while (i >= 0 && p > preorder[i]) {
                low = preorder[i];
                i--;
            }
            
            preorder[++i] = p;
        }
        return true;
    }
}