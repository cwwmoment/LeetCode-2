/**
 * Created on 29 Mar 2019 by happygirlzt
 *
 * LeetCode #981. Time Based Key-Value Store
 *
 */

class TimeMap {
    class Item {
        String key;
        String value;
        public Item(String k, String v) {
            key = k;
            value = v;
        }
    }

    private TreeMap<Integer, Item> map;
    /** Initialize your data structure here. */
    public TimeMap() {
        map = new TreeMap<>();
    }

    public void set(String key, String value, int timestamp) {
        map.put(timestamp, new Item(key, value));
    }

    public String get(String key, int timestamp) {
        int time = timestamp;
        while (map.floorKey(time) != null) {
            Integer floor = map.floorKey(time--);
            if (map.get(floor).key.equals(key)) {
                return map.get(floor).value;
            }
        }

        return "";
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */

// A little bit optimization
class TimeMap {
    Map<String, TreeMap<Integer, String>> m;
    /** Initialize your data structure here. */
    public TimeMap() {
        m = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if (!m.containsKey(key)) {
            m.put(key, new TreeMap<>());
        }

        m.get(key).put(timestamp, value);
    }

    public String get(String key, int timestamp) {
        if (!m.containsKey(key)) return "";

        TreeMap<Integer, String> tree = m.get(key);
        Integer t = tree.floorKey(timestamp);
        return t != null ? tree.get(t) : "";
    }
}
