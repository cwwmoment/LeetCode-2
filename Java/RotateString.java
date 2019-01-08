/**
 * Created on 8 Jan 2019 by happygirlzt
 *
 * LeetCode #796. Rotate String
 *
 */

class Solution {
    public boolean rotateString(String A, String B) {
        return A.length() == B.length() && (A + A).contains(B);
    }
}
