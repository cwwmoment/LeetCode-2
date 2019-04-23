/**
 * Created on 23 Apr 2019 by happygirlzt
 *
 * LeetCode #635. Design Log Storage System
 *
 */

class LogSystem {
    private TreeMap<String, Integer> map;
    private Map<String, int[]> strMap;
    public LogSystem() {
        map = new TreeMap<>();
        strMap = new HashMap<>();
        strMap.put("Year", new int[]{0, 4});
        strMap.put("Month", new int[]{1, 6});
        strMap.put("Day", new int[]{2, 8});
        strMap.put("Hour", new int[]{3, 10});
        strMap.put("Minute", new int[]{4, 12});
        strMap.put("Second", new int[]{5, 14});
    }

    public void put(int id, String timestamp) {
        map.put(stampToString(timestamp), id);
    }

    public List<Integer> retrieve(String s, String e, String gra) {

        List<Integer> res = new ArrayList<>();
        StringBuilder ss = new StringBuilder();
        StringBuilder es = new StringBuilder();
        String[] s1 = s.split(":");
        String[] s2 = e.split(":");

        int index = strMap.get(gra)[0];
        int len = strMap.get(gra)[1];
        for (int i = 0; i <= index; i++) {
            ss.append(s1[i]);
            es.append(s2[i]);
        }

        String sStr = ss.toString();
        String eStr = es.toString();

        for (String key : map.keySet()) {
            String cur = key.substring(0, len);

            if (cur.compareTo(sStr) >= 0 &&
                cur.compareTo(eStr) <= 0) {
                res.add(map.get(key));
            }
        }
        return res;
    }

    private String stampToString(String timestamp) {
        StringBuilder sb = new StringBuilder();
        String[] ss = timestamp.split(":");
        for (String s : ss) {
            sb.append(s);
        }

        return sb.toString();
    }
}

/**
 * Your LogSystem object will be instantiated and called as such:
 * LogSystem obj = new LogSystem();
 * obj.put(id,timestamp);
 * List<Integer> param_2 = obj.retrieve(s,e,gra);
 */
