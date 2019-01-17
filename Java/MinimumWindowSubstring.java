/**
 * Created on 26 Sep 2018 by happygirlzt
 *
 * LeetCode #76. Minimum Window Substring
 */

public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";
                HashMap<Character, ArrayList<Integer>> map = new HashMap<>();
        char[] cs = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(cs[i])) {
                ArrayList<Integer> tmp = map.get(cs[i]);
                tmp.add(i);
                map.put(cs[i], tmp);
            } else {
                ArrayList<Integer> tmp = new ArrayList<>();
                tmp.add(i);
                map.put(cs[i], tmp);
            }
        }

       // System.out.println(map);
        char[] tc = t.toCharArray();
        HashMap<Character, Integer> map1 = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            if (map1.containsKey(tc[i])) {
                map1.put(tc[i], ++map1.get(tc[i]));
            } else {
                map1.put(tc[i], 1);
            }
        }

        for (int i = 0; i < t.length(); i++) {
            if (!map.containsKey(tc[i])) return "";
            if (map1.get(tc[i]) > map.get(tc[i]).size()) return "";
        }
        String res = "";
        if (t.length() == 1) {
            if (map.containsKey(tc[0])) {
                return t;
            } else {
                return res;
            }
        }

        int beg = s.length(), end = -s.length();

        if (!map.containsKey(tc[0]) || !map.containsKey(tc[1])) return res;
        for (int i = 0; i < map.get(tc[0]).size(); i++) {
            for (int j = 0; j < map.get(tc[1]).size(); j++) {
                if (Math.abs(map.get(tc[1]).get(j) - map.get(tc[0]).get(i)) < Math.abs(end - beg)) {
                    beg = Math.min(map.get(tc[1]).get(j), map.get(tc[0]).get(i));
                    end = Math.max(map.get(tc[1]).get(j), map.get(tc[0]).get(i));
                }
            }
        }

      // System.out.println("beg " +beg);
        //System.out.println("end " +end);

        loops:
        for (int k = 2; k < t.length(); k++) {
            if (!map.containsKey(tc[k])) {
                return res;
            } else {
                int size = map.get(tc[k]).size();
                 int tpMin = -s.length(), tpMax = s.length() * 2;
                for (int i = 0; i < size; i++) {

                    int temp = map.get(tc[k]).get(i);
                     //System.out.println("temp " + temp);
                    if (temp > beg && temp < end) {
                        continue loops;
                    } else if (temp < beg) {
                        tpMin = Math.max(temp, tpMin);
                         //System.out.println(tpMin);
                    } else if (temp > end) {
                        tpMax = Math.min(temp, tpMax);
                        // System.out.println("tpMax " + tpMax);
                    }
                }

               // System.out.println(Math.abs(tpMin - beg));
                //System.out.println(Math.abs(tpMax - end));

                if (Math.abs(tpMin - beg) < Math.abs(tpMax - end)) {
                    beg = tpMin;
                } else {
                    end = tpMax;
                }
            }
        }


        res = s.substring(beg, end + 1);
        return res;
    }

    // 正确解法
    public String minWindow(String s, String t) {

        int num = t.length(), len = Integer.MAX_VALUE, start = 0, left = 0;

        char[] tc = t.toCharArray();
        char[] sc = s.toCharArray();

        int[] dict = new int[128];  // 要注意常用的char的ASCII的个数是128，有时用256
        for (int i = 0; i < tc.length; i++) {
            dict[tc[i]]++;
        }

        for (int i = 0, j = 0; j < sc.length; j++) {
            if (dict[sc[j]] > 0) num--;
            dict[sc[j]]--;

            while (num == 0) {
                if (len > j - i + 1) {
                    len = j - i + 1;
                    start = i;
                }

                if (dict[sc[i]] == 0) num++;

                dict[sc[i]]++;
                i++;
            }
        }

        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }

    // Updated on 17 Jan 2019
    public String minWindow(String s, String t) {
        int[] map = new int[128];
        for (char c: t.toCharArray()) {
            map[c]++;
        }

        int lo = 0, hi = 0;
        int[] res = new int[2];
        int min = Integer.MAX_VALUE;
        int counter = t.length();
        while (hi < s.length()) {
            char cur = s.charAt(hi);
            if (map[cur] > 0) counter--;
            map[cur]--;
            hi++;
            while (counter == 0) {
                if (min > hi - lo + 1) {
                    min = hi - lo + 1;
                    res[0] = lo;
                    res[1] = hi;
                }

                char low = s.charAt(lo);
                map[low]++;
                if (map[low] > 0) counter++;
                lo++;
            }
        }

        return min == Integer.MAX_VALUE ? "" : s.substring(res[0], res[1] + 1);
    }
}
