/**
 * Created on 23 Feb 2019 by happygirlzt
 * 
 * LeetCode #358. Rearrange String k Distance Apart
 */

class Solution {
    class Item {
        int count;
        char c;
        public Item(int count, char c) {
            this.count = count;
            this.c = c;
        }
    }
    
    public String rearrangeString(String s, int k) {
        if (k == 0 || s.length() == 1) return s;
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        PriorityQueue<Item> maxHeap = new PriorityQueue<>((a, b) -> a.count == b.count ? a.c - b.c : b.count - a.count);
        
        for (char c : map.keySet()) {
            maxHeap.offer(new Item(map.get(c), c));
        }
        
        StringBuilder sb = new StringBuilder();
        while (maxHeap.size() >= k) {
            List<Item> tmp = new ArrayList<>();
            for (int i = 0; i < k; i++) {
                if (maxHeap.size() > 0) {
                    Item item = maxHeap.poll();
                    tmp.add(item);
                    sb.append(item.c);
                }
            }
            
            if (tmp.size() < k) return "";
            for (Item item : tmp) {
                if (--item.count > 0)
                   maxHeap.offer(item);
            }
        }
        
        while (maxHeap.size() > 0) {
            sb.append(maxHeap.poll().c);
        }
        
        
        return sb.length() == s.length() ? sb.toString() : "";
    }
}