/**
 * Created on 9 Jan 2019 by happygirlzt
 *
 * LeetCode #288. Unique Word Abbreviation
 *
 */

class ValidWordAbbr {

    Map<String, String> map;
    Map<String, Boolean> dict;
    public ValidWordAbbr(String[] dictionary) {
        map = new HashMap<>();
        dict = new HashMap<>();

        for (String s : dictionary) {
            String abbr = getAbbr(s);
            String pre = map.put(abbr, s);

            if (pre != null && !pre.equals(s)) {
                dict.put(abbr, false);
            } else {
                dict.put(abbr, true);
            }
        }
    }

    public boolean isUnique(String word) {
        String abbr = getAbbr(word);

        if (!map.containsKey(abbr) || !dict.containsKey(abbr) || dict.get(abbr) && map.get(abbr).equals(word)) {
            return true;
        } else {
            return false;
        }
    }

    private String getAbbr(String s) {
        int n = s.length();
        if (n <= 2) return s;
        return s.charAt(0) + String.valueOf(n - 2) + s.charAt(n - 1);
    }
}

/**
 * Your ValidWordAbbr object will be instantiated and called as such:
 * ValidWordAbbr obj = new ValidWordAbbr(dictionary);
 * boolean param_1 = obj.isUnique(word);
 */
