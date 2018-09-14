/**
 * Created on 14 Sep 2018 by happygirlzt
 *
 * LeetCode #60 Permutation Sequence
 */

public class PermutationSequence {
    public String getPermutation(int n, int k) {
        List<Character> list = new ArrayList<>();
        List<String> chosen = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add((char)(i + '0'));
        }
        helper(list, "", chosen);

        return chosen.get(k - 1);
    }

    public void helper(List<Character> list, String s, List<String> chosen) {
        // base case
        if (list.size() == 0) {
            chosen.add(s);
        } else {
            // choose
            for (int i = 0; i < list.size(); i++) {
                char tmp = list.get(i);
                s = s + tmp;
                list.remove(i);

                // explore
                helper(list, s, chosen);

                // unchoose
                s = s.substring(0, s.length() - 1);
                list.add(i, tmp);
            }
        }
    }
}
