/**
 * Created on 17 Jan 2019 by happygirlzt
 *
 * LeetCode #706. Design HashMap
 *
 */
class MyHashMap {

    private static final int SIZE = 16;
    private Entry[] table;

    class Entry {
        final String key;
        String value;
        Entry next;

        Entry(String k, String v) {
            key = k;
            value = v;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public String getKey() {
            return key;
        }
    }
    /** Initialize your data structure here. */
    public MyHashMap() {
        table = new Entry[SIZE];
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        int hash = key.hashCode() % SIZE;
        Entry e = table[hash];

        if (e != null) {
            if (e.key.equals(key)) {
                e.value = value;
            } else {
                while (e.next != null) {
                    e = e.next;
                }

                Entry entryInOldBucket = new Entry(key, value);
                e.next = entryInOldBucket;
            }
        } else {
            Entry entryInNewBucket = new Entry(key, value);
            table[hash] = entryInNewBucket;
        }
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int hash = key.hashCode() % SIZE;
        Entry e = table[hash];

        while (e != null) {
            if (e.key.equals(key)) {
                return e;
            }
            e = e.next;
        }

        return null;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int hash = key.hashCode() % SIZE;
        Entry e = table[hash];

        if (e != null) {
            e = null;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
