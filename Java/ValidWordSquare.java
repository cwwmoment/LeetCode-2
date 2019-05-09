/**
 * Created on 9 May 2019 by happygirlzt
 *
 * LeetCode #422. Valid Word Square
 *
 */

class Solution {
    public boolean validWordSquare(List<String> words) {
        if (words == null || words.size() == 0) return true;
        int rows = words.size(), cols = words.get(0).length();
        for (int i = 0; i < rows; i++) {
            cols = Math.max(cols, words.get(i).length());
        }

        for (int i = 0; i < rows; i++) {
            if (!checkRowAndCol(words, i, i, rows, cols)) return false;
        }

        return true;
    }

    private boolean checkRowAndCol(List<String> words, int row, int col, int rows, int cols) {
        StringBuilder rSb = new StringBuilder();
        StringBuilder cSb = new StringBuilder();
        for (int i = 0; i < rows; i++) {
            if (col >= words.get(i).length()) {
                cSb.append(" ");
            } else
                cSb.append(words.get(i).charAt(col));
        }

        for (int j = 0; j < cols; j++) {
            if (words.get(row).length() <= j) {
                rSb.append(" ");
            } else
                rSb.append(words.get(row).charAt(j));
        }

        return cSb.toString().equals(rSb.toString());
    }
}
