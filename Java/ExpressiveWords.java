/**
 * Created on 18 Mar 2019 by happygirlzt
 *
 * LeetCode #809. Expressive Words
 *
 */

class Solution {
    public int expressiveWords(String S, String[] words) {
        int count = 0;
        for (String word: words) {
            if (check(S, word)) {
                count++;
            }
        }

        return count;
    }

    private boolean check(String word, String pattern) {
        int wordPointer = 0;
        int patternPointer = 0;
        for (; wordPointer < word.length(); wordPointer++) {
            if (patternPointer < pattern.length() && word.charAt(wordPointer) == pattern.charAt(patternPointer)) {
                patternPointer++;
            } else if (wordPointer > 1 && word.charAt(wordPointer) == word.charAt(wordPointer - 1) && word.charAt(wordPointer - 1) == word.charAt(wordPointer - 2));
            else if (wordPointer > 0 && wordPointer < word.length() - 1 && word.charAt(wordPointer) == word.charAt(wordPointer - 1) && word.charAt(wordPointer) == word.charAt(wordPointer + 1));
            else return false;
        }

        return patternPointer == pattern.length();
    }
}
