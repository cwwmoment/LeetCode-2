class Solution {
    public int[][] transpose(int[][] A) {
        int len = A.length;
        int leng = A[0].length;
        int[][] trans = new int[leng][len];

        for (int i = 0; i < leng; i++) {
            for (int j = 0; j < len; j++) {
                trans[i][j] = A[j][i];
            }
        }

        return trans;
    }
}
