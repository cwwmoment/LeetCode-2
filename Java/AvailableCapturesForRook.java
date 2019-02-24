/**
 * Created on 24 Feb 2019 by happygirlzt
 * 
 * LeetCode #999. Available Captures for Rook
 */
 
class Solution {
    public int findJudge(int N, int[][] trust) {
        Set<Integer> from = new HashSet<>();
 
        int[] inDegree = new int[N + 1];
        for (int[] e: trust) {
            from.add(e[0]);
            inDegree[e[1]]++;
        }
        
        int candidate = -1;
        for (int i = 1; i <= N; i++) {
            if (inDegree[i] == N - 1 && !from.contains(i)) {
                return i;
            }
        }
        
        return -1;
    }
}