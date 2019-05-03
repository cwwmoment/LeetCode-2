/**
 * Created on 3 May 2019 by happygirlzt
 *
 * LeetCode #966. Vowel Spellchecker
 *
 */

// This is a very bad-described question
class Solution {
    private Set<Character> vowels;
    public String[] spellchecker(String[] wordlist, String[] queries) {

        Map<String, String> map = new HashMap<>();
        vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');

        Map<String, String> lower = new HashMap();
        Set<String> set = new HashSet<>();
        for (String word : wordlist) {
            set.add(word);

            String modified = word.toLowerCase();
            // Cannot just use put()
            // it will return the first string
            lower.putIfAbsent(modified, word);

            String wildcarded = toWildCard(modified);
            map.putIfAbsent(wildcarded, word);
        }

        int n = queries.length;
        String[] res = new String[n];
        int index = 0;

        for (String q : queries) {
            if (set.contains(q)) {
                res[index++] = q;
                continue;
            }

            String modified = q.toLowerCase();

            if (lower.containsKey(modified)) {
                res[index++] = lower.get(modified);
                continue;
            }


            String wildcarded = toWildCard(modified);
            if (map.containsKey(wildcarded)) {
                res[index++] = map.get(wildcarded);
                continue;
            }

            res[index++] = "";

        }
        return res;
    }

    private String toWildCard(String q) {
        StringBuilder sb = new StringBuilder(q);
        for (int i = 0; i < sb.length(); i++) {
            char c = sb.charAt(i);
            if (vowels.contains(c)) {
                sb.setCharAt(i, '*');
            }
        }

        return sb.toString();
    }
}
