/**
 * Created on 18 Feb 2019 by happygirlzt
 *
 * LeetCode #792. Number of Matching Subsequences
 */

public class Solution {
    public int numMatchingSubseq(String S, String[] words) {
        Map<Character, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < S.length(); i++) {
            map.putIfAbsent(S.charAt(i), new ArrayList<>());
            map.get(S.charAt(i)).add(i);
        }

        int count = 0;
        for (String word : words) {
            if (isSubsequence(word, S, map))
                count++;
        }

        return count;
    }

    public boolean isSubsequence(String s, String t, Map<Character, List<Integer>> map) {
        int prev = -1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!map.containsKey(c))
                return false;
            int index = binarySearch(map.get(c), 0, map.get(c).size() - 1, prev);
            if (index == -1)
                return false;
            prev = index;
        }

        return true;
    }

    private int binarySearch(List<Integer> list, int lo, int hi, int prev) {
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (list.get(mid) <= prev) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }

        return list.get(lo) > prev ? list.get(lo) : -1;
    }

    // Updated on 31 Mar 2019
    public int numMatchingSubseq(String S, String[] words) {
        int count = 0;
        Set<String> sub = new HashSet<>();
        Set<String> nonSub = new HashSet<>();

        for (String word : words) {
            if (sub.contains(word)) {
                count++;
                continue;
            }

            if (nonSub.contains(word)) {
                continue;
            }

            if (isSub(word, S)) {
                sub.add(word);
                count++;
            } else {
                nonSub.add(word);
            }
        }

        return count;
    }

    private boolean isSub(String word, String s) {
        if (word.length() > s.length()) return false;
        int indexW = 0, indexS = 0;
        while (indexW < word.length() && indexS < s.length()) {
            if (word.charAt(indexW) == s.charAt(indexS)) {
                indexW++;
                indexS++;
            } else {
                indexS++;
            }
        }

        return indexW == word.length();
    }
}
