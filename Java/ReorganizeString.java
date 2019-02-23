/**
 * Created on 23 Feb 2019 by happygirlzt
 * 
 * LeetCode #767. Reorganize String
 */

 // Time: O(NlogA), N is the length of the S, A is the size of
 // different chars
 // Space: O(A)
class Solution {
    class Item {
        int count;
        char c;
        
        public Item(int count, char c) {
            // Here may have bug, should use this.
            this.count = count;
            this.c = c;
        }
    }
    public String reorganizeString(String S) {
        if (S == null || S.isEmpty()) return "";
//        int[] map = new int[26];
        Map<Character, Integer> map = new HashMap<>();
        for (char c : S.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        PriorityQueue<Item> maxHeap = new PriorityQueue<>((a, b) -> a.count == b.count ? a.c - b.c : b.count - a.count);
        for (char c : map.keySet()) {
            if (map.get(c) > (S.length() + 1) / 2) return "";
            maxHeap.offer(new Item(map.get(c), c));
        }
        
        StringBuilder sb = new StringBuilder();
        while (maxHeap.size() >= 2) {
            Item i1 = maxHeap.poll();
            Item i2 = maxHeap.poll();
            sb.append(i1.c);
            sb.append(i2.c);
            if (--i1.count > 0) maxHeap.offer(i1);
            if (--i2.count > 0) maxHeap.offer(i2);
        }
        
        if (maxHeap.size() > 0) sb.append(maxHeap.poll().c);
        return sb.toString();
    }
}