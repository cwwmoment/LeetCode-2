/**
 * Created on 3 Nov 2018 by happygirlzt
 *
 * LeetCode #159. Longest Substring with At Most Two Distinct Characters
 *
 */

public class LongestSubstringWithAtMostTwoDistinctCharacters {
    // My ugly solution
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s == null || s.length() == 0) return 0;
        int len = s.length();
        if (len == 1 || len == 2) return len;

        char[] sc = s.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();

        char beg = sc[0], end = sc[0];
        int res = 0;
        int r = 0;
        map.put(sc[0], 1);
        for (int i = 1; i < len; i++) {
            if (map.size() == 1) {
                if (sc[i] != beg) {
                    end = sc[i];
                    map.put(sc[i], 1);
                    res = map.get(beg) + map.get(end);
                } else {
                    map.put(sc[i], map.get(sc[i]) + 1);
                    res = map.get(beg);
                }
            } else if (sc[i] == beg || sc[i] == end) {
                map.put(sc[i], map.get(sc[i]) + 1);
                res = map.get(beg) + map.get(end);
                if (sc[i] != end) {
                    char tmp = end;
                    end = sc[i];
                    beg = tmp;
                }
            } else {
                res = 0;
                map.put(sc[i], 1);
                map.put(end, 1);
                beg = end;
                end = sc[i];
                int t = 0;
                for (int j = i - 2; j > 0; j--) {
                    if (sc[j] == beg) {
                        t++;
                    } else {
                        break;
                    }
                }
                map.put(beg, map.get(beg) + t);
                res = map.get(beg) + map.get(end);
            }
            r = Math.max(res, r);
        }

        return r;
    }

    // Other's smart solution
    public int solution1(String s) {
        int count = 0;
        int[] map = new int[256];
        int beg = 0, end = 0;
        int res = 0;

        while (end < s.length()) {
            if (map[s.charAt(end++)]++ == 0) {
                count++;
            }

            while (count > 2) {
                if (map[s.charAt(beg++)]-- == 1) {
                    count--;
                }
            }

            res = Math.max(res, (end - beg));
        }

        return res;
    }
}
