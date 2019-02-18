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
}