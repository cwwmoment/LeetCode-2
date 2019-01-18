/**
 * Created on 18 Jan 2019 by happygirlzt
 *
 * LeetCode #953. Verifying an Alien Dictionary
 *
 */

class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> map = new HashMap<>();
        int i = 0;
        for (char c : order.toCharArray()) {
            // System.out.println(map);
            map.put(c, i++);
        }

        PriorityQueue<String> heap = new PriorityQueue<>((w0, w1) -> {
                for (int j = 0; j < Math.min(w0.length(), w1.length()); j++) {
                    if (map.get(w0.charAt(j)) < map.get(w1.charAt(j))) {
                        return -1;
                    } else if (map.get(w0.charAt(j)) > map.get(w1.charAt(j))) {
                        return 1;
                    }
                }

                return -1;
            });

        for (String s: words) {
            heap.add(s);
        }

        i = 0;
        while (heap.size() > 0) {
            System.out.println(heap.peek());
            if (!heap.remove().equals(words[i++])) return false;
        }

        return true;
    }

    // Solution 2
    int[] map = new int[26];

    public boolean isAlienSorted(String[] words, String order) {
        for (int i = 0; i < order.length(); i++) {
            map[order.charAt(i) - 'a'] = i;
        }

        for (int i = 1; i < words.length; i++) {
            if (compare(words[i - 1], words[i]) > 0) {
                return false;
            }
        }

        return true;
    }

    private int compare(String s1, String s2) {
        int n = s1.length(), m = s2.length(), cmp = 0;
        for (int i = 0, j = 0; i < n && j < m && cmp == 0; i++, j++) {
            cmp = map[s1.charAt(i) - 'a'] - map[s2.charAt(j) - 'a'];
        }

        return cmp == 0 ? n - m : cmp;
    }

}
