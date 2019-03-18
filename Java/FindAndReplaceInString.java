/**
 * Created on 18 Mar 2019 by happygirlzt
 *
 * LeetCode #833. Find And Replace in String
 *
 */

class Solution {
    public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < indexes.length; i++) {
            map.put(indexes[i], i);
        }
        Arrays.sort(indexes);

        StringBuilder sb = new StringBuilder();
        if (indexes[0] > 0) {
            sb.append(S.substring(0, indexes[0]));
        }
        for (int i = 0; i < indexes.length; i++) {
            int index = map.get(indexes[i]);

            if (S.indexOf(sources[index], indexes[i]) == indexes[i]) {
                sb.append(targets[index]);
            } else {
                sb.append(S.substring(indexes[i], indexes[i] + sources[index].length()));
            }

            if (i != indexes.length - 1) {
                if (indexes[i] + sources[index].length() < indexes[i + 1]) {
                    sb.append(S.substring(indexes[i] + sources[index].length(), indexes[i + 1]));
                }
            } else {
                if (indexes[i] + sources[index].length() < S.length()) {
                    sb.append(S.substring(indexes[i] + sources[index].length()));
                }
            }
        }

        return sb.toString();
    }
}
