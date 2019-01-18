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
        // System.out.println(isVowel('a'));
        for (String word: words) {
            index++;
            // System.out.println(word);
            StringBuilder res = new StringBuilder();
            if (isVowel(word.charAt(0))) {
                // System.out.println(word.charAt(0));
                res.append(word);
            } else {
                // System.out.println(word.charAt(0));
                // char first = word.charAt(0);
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
        // System.out.println(vowels);
        if (vowels.contains(c)) return true;
        return false;
    }
}
