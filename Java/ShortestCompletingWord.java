/**
 * Created on 23 Mar 2019 by happygirlzt
 *
 * LeetCode #748. Shortest Completing Word
 *
 */

class Solution {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        Map<Character, Integer> freq = new HashMap<>();
        getFrequence(freq, licensePlate);
        PriorityQueue<String> heap = new PriorityQueue<>((a, b) -> a.length() - b.length());
        Map<Character, Integer> map;
        for (String str: words) {
            map = new HashMap<>();
            getFrequence(map, str);

            boolean notMatch = false;
            for (char key : freq.keySet()) {
                if (!map.containsKey(key) || freq.get(key) > map.get(key)) {
                    notMatch = true;
                    break;
                }
            }

            if (!notMatch) {
                heap.offer(str);
            }
        }
        if (heap.size() > 0) return heap.poll();
        return "";
    }

    private String getFrequence(Map<Character, Integer> map, String s) {
        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (c == ' ') continue;
            if (Character.isDigit(c)) continue;
            c = Character.toLowerCase(c);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < 26; i++) {
            if (map.containsKey((char) (i + 'a'))) {
                sb.append((char) (i + 'a'));
                sb.append(map.get((char) (i + 'a')));
            }
        }

        return sb.toString();
    }
}
