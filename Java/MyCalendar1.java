/**
 * Created on 28 Dec 2018 by happygirlzt
 *
 * LeetCode #729. My Calendar I
 *
 */

class MyCalendar {
    private TreeMap<Integer, Integer> map;
    public MyCalendar() {
        map = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        Integer prev = map.floorKey(start), next = map. ceilingKey(start);
        if ((prev == null || map.get(prev) <= start) && (next == null || next >= end)) {
            map.put(start, end);
            return true;
        }

        return false;
    }
}
