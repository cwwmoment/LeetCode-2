/**
 * Created on 2 Jan 2019 by happygirlzt
 *
 * LeetCode #392. Is Subsequence
 *
 */

class Solution {
    public boolean isSubsequence(String s, String t) {
        if (s == null || s.length() == 0) return true;
        char[] cs = s.toCharArray();
        char[] ts = t.toCharArray();
        int i = 0;
        for (int j = 0; j < ts.length; j++) {
            if (i == cs.length) return true;
            if (cs[i] == ts[j]) {
                i++;
            }
        }

        return i == cs.length;
    }

    // Updated on 18 Feb 2019 Linear Scan
    public boolean isSubsequence1(String s, String t) {
        if (s.length() == 0) return true;
        if (t.length() < s.length()) return false;
        int i = 0, j = 0;
        while (j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
                if (i == s.length()) return true;
            }
            
            j++;
        }
        
        return false;
    }

    // Binary Search
    public boolean isSubsequence2(String s, String t) {
        // Build the map
        Map<Character, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            map.putIfAbsent(t.charAt(i), new ArrayList<>());
            map.get(t.charAt(i)).add(i);
        }
        
        int prev = -1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!map.containsKey(c)) return false;
            int index = binarySearch(map.get(c), 0, map.get(c).size() - 1, prev);
            // System.out.println(index);
            if (index == -1) return false;
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
