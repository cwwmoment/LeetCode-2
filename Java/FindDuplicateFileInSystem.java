/**
 * Created on 14 Apr 2019 by happygirlzt
 *
 * LeetCode #609. Find Duplicate File in System
 *
 */

class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String path: paths) {
            String[] strs = path.split(" ");
            String address = strs[0];

            for (int i = 1; i < strs.length; i++) {
                boolean fileName = true;
                StringBuilder sb = new StringBuilder(address);
                sb.append("/");
                StringBuilder content = new StringBuilder();
                for (int j = 0; j < strs[i].length(); j++) {
                    if (fileName && strs[i].charAt(j) != '(') {
                        sb.append(strs[i].charAt(j));
                    } else if (strs[i].charAt(j) == '(') {
                        fileName = false;
                    } else if (strs[i].charAt(j) != ')') {
                        content.append(strs[i].charAt(j));
                    } else if (strs[i].charAt(j) == ')') {
                        map.putIfAbsent(content.toString(), new ArrayList<>());
                        map.get(content.toString()).add(sb.toString());
                    }
                }
            }
        }

        for (String c: map.keySet()) {
            if (map.get(c).size() > 1) {
                res.add(map.get(c));
            }
        }

        return res;
    }
}
