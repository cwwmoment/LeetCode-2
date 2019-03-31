/**
 * Created on 31 Mar 2019 by happygirlzt
 *
 * LeetCode #1023. Binary String With Substrings Representing 1 To N
 *
 */

class Solution {
    public boolean queryString(String S, int N) {
        for (int i = 1; i <= N; i++) {
            String bp = getBinaryRep(i);
            if (S.indexOf(bp) == -1) return false;
        }
        return true;
    }

    private String getBinaryRep(int N) {
        StringBuilder sb = new StringBuilder();
        while (N > 0) {
            sb.append(N % 2);
            N = N / 2;
        }

        return sb.reverse().toString();
    }
}
