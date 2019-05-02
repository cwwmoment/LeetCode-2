/**
 * Created on 2 May 2019 by happygirlzt
 *
 * LeetCode #937. Reorder Log Files
 *
 */

class Solution {
    public String[] reorderLogFiles(String[] logs) {
        int n = logs.length;
        List<String> list = new ArrayList<>();
        TreeMap<String, String> map = new TreeMap<>();
        for (String log : logs) {
            String[] splited = log.split(" ");
            if (Character.isDigit(splited[1].charAt(0))) {
                list.add(log);
            } else {
                StringBuilder sb = new StringBuilder();
                for (int i = 1; i < splited.length; i++) {
                    sb.append(splited[i]);
                    sb.append(" ");
                }
                sb.append(splited[0]);
                map.put(sb.toString(), log);
            }
        }

        String[] res = new String[n];
        int index = 0;
        for (String key : map.keySet()) {
            res[index++] = map.get(key);
        }

        for (String str : list) {
            res[index++] = str;
        }

        return res;
    }
}
