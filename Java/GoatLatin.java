/**
 * Created on 18 Jan 2019 by happygirlzt
 *
 * LeetCode #824. Goat Latin
 *
 */

class Solution {
    public String toGoatLatin(String s) {
        if (s == null || s.length() == 0) return s;
        int index = 0;
        String[] words = s.split(" ");
        StringBuilder r = new StringBuilder();

        for (String word: words) {
            index++;

            StringBuilder res = new StringBuilder();
            if (isVowel(word.charAt(0))) {

                res.append(word);
            } else {

                res.append(word.substring(1));
                res.append(word.substring(0, 1));
            }

            res.append("ma");
            for (int i = 1; i <= index; i++) {
                res.append('a');
            }

            r.append(res);
            r.append(' ');
        }

        r.deleteCharAt(r.length() - 1);
        return r.toString();
    }

    private boolean isVowel(char c) {
        List<Character> v = Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
        Set<Character> vowels = new HashSet(v);

        if (vowels.contains(c)) return true;
        return false;
    }

    // Updated on 1 Mar 2019
    private final Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));

    public String toGoatLatin(String S) {

        String[] strs = S.split(" ");
        String[] modified = new String[strs.length];

        int index = 1;
        for (String s : strs) {
            if (!startVowel(s)) {
                s = modifyCons(s);
            }
            s = addMa(index++, s);
            modified[index - 2] = s;
        }

        return String.join(" ", modified);
    }

    private boolean startVowel(String s) {
        char c = s.charAt(0);
        if (vowels.contains(c)) return true;
        return false;
    }

    private String addMa(int index, String s) {
        StringBuilder sb = new StringBuilder();
        sb.append("ma");
        for (int i = 0; i < index; i++) {
            sb.append("a");
        }

        s += sb.toString();
        return s;
    }

    private String modifyCons(String s) {
        StringBuilder sb = new StringBuilder(s);
        char c = sb.charAt(0);
        sb.deleteCharAt(0);
        sb.append(c);
        return sb.toString();
    }
}
