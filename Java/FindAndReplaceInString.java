/**
 * Created on 18 Mar 2019 by happygirlzt
 *
 * LeetCode #833. Find And Replace in String
 *
 */

class Solution {
    // Updated on 31 Mar 2019
    // O(NlogN)
    public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < indexes.length; i++) {
            if (S.indexOf(sources[i], indexes[i]) == indexes[i]) {
                map.put(indexes[i], i);
            }
        }

        StringBuilder sb = new StringBuilder();
        int index = 0;
        for (int p : map.keySet()) {
            if (p > index) {
                sb.append(S.substring(index, p));
                // index = p;
            }

            sb.append(targets[(map.get(p))]);
            index = p + sources[map.get(p)].length();
        }

        if (index != S.length()) {
            sb.append(S.substring(index));
        }
        return sb.toString();
    }

    // O(N)
    public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
        int n = S.length();
        int[] match = new int[n];
        Arrays.fill(match, -1);

        for (int i = 0; i < indexes.length; i++) {
            if (S.substring(indexes[i], indexes[i] + sources[i].length()).equals(sources[i])) {
                match[indexes[i]] = i;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n;) {
            if (match[i] != -1) {
                sb.append(targets[match[i]]);
                i += sources[match[i]].length();
            } else {
                sb.append(S.charAt(i));
                i++;
            }
        }

        return sb.toString();
    }
}
