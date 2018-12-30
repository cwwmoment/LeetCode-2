/**
 * Created on 30 Dec 2018 by happygirlzt
 *
 * LeetCode #500. Keyboard Row
 *
 */

class Solution {
    public String[] findWords(String[] words) {
        Map<Integer, String> map = new HashMap<>();
        map.put(0, "qwertyuiop");
        map.put(1, "asdfghjkl");
        map.put(2, "zxcvbnm");

        List<String> res = new ArrayList<>();
        boolean[] check = new boolean[words.length];
        int index = 0;
        for (String s: words) {
            s = s.toLowerCase();
            int row = 0;
            if (map.get(0).indexOf(s.charAt(0)) != -1) {
                row = 0;
            } else if (map.get(1).indexOf(s.charAt(0)) != -1) {
                row = 1;
            } else {
                row = 2;
            }

            boolean flag = true;
            for (char c: s.toCharArray()) {
                if (map.get(row).indexOf(c) == -1) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                res.add(words[index]);
            }
            index++;
        }


        return res.toArray(new String[res.size()]);
    }
}
