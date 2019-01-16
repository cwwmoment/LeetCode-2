/**
 * Created on 16 Jan 2019 by happygirlzt
 *
 * LeetCode #418. Sentence Screen Fitting
 *
 */

class Solution {
    public int wordsTyping(String[] sent, int r, int c) {
        String s = String.join(" ", sent) + " ";
        int start = 0, l = s.length();

        for (int i = 0; i < r; i++) {
            start += c;
            if (s.charAt(start % l) == ' ') {
                start++;
            } else {
                while (start > 0 && s.charAt((start-1) % l) != ' ') {
                    start--;
                }
            }
        }

        return start / s.length();
    }
}
