/**
 * Created on 28 Dec 2018 by happygirlzt
 *
 * LeetCode #732. My Calendar III
 *
 */
class MyCalendarThree {
    private TreeMap<Integer, Integer> map;
    public MyCalendarThree() {
        map = new TreeMap<>();
    }

    public int book(int start, int end) {
        map.put(start, map.getOrDefault(start, 0) + 1);
        map.put(end, map.getOrDefault(end, 0) - 1);

        int sum = 0, k = 0;
        for (Integer d: map.values()) {
            sum += d;
            if (sum > k) {
                k = sum;
            }
        }

        return k;
    }
}
