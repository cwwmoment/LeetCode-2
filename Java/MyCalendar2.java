/**
 * Created on 28 Dec 2018 by happygirlzt
 *
 * LeetCode #731. My Calendar II
 *
 */
class MyCalendarTwo {
    private TreeMap<Integer, Integer> map;
    public MyCalendarTwo() {
        map = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        map.put(start, map.getOrDefault(start, 0) + 1);
        map.put(end, map.getOrDefault(end, 0) - 1);
        int sum = 0;
        for (Integer d: map.values()) {
            sum += d;
            if (sum >= 3) {
                map.put(start, map.get(start) - 1);
                map.put(end, map.get(end) + 1);
                return false;
            }
        }

        return true;
    }
}
