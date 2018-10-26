/**
 * Created on 26 Oct 2018 by happygirlzt
 *
 * LeetCode #763. Partition Labels
 *
 */

public class PartitionLabels {
    public List<Integer> partitionLabels(String s) {
        List<Integer> res = new ArrayList<>();
        if (s == null || s.length() == 0) return res;

        int[] map = new int[26];
        char[] cs = s.toCharArray();

        // Save the last index of a char
        for (int i = 0; i < cs.length; i++) {
            map[cs[i] - 'a'] = i;
        }

        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            end = Math.max(end, map[cs[i] - 'a']);

            if (end == i) {
                res.add(end - start + 1);
                start = end + 1;
            }
        }

        return res;
    }
}
