/**
 * Created on 23 Dec 2018 by happygirlzt
 *
 * LeetCode #243. Shortest Word Distance
 *
 */

class Solution {
    // Slow solution
    public int shortestDistance(String[] words, String word1, String word2) {
        Map<String, List<Integer>> map = new HashMap<>();
        int index = 0;
        for (String word : words) {
            map.putIfAbsent(word, new ArrayList<>());
            map.get(word).add(index++);
        }

        List<Integer> list1 = map.get(word1);
        List<Integer> list2 = map.get(word2);

        int min = Integer.MAX_VALUE;
        for (int pos : list1) {
            int num = pos;
            int insertPos = Collections.binarySearch(list2, num);
            insertPos = -(insertPos + 1);

            if (insertPos == list2.size()) {
                min = Math.min(min, num - list2.get(list2.size() - 1));
            } else if (insertPos == 0) {
                min = Math.min(min, list2.get(0) - num);
            } else {
                int prev = insertPos - 1;
                int next = insertPos + 1 == list2.size() ? insertPos : insertPos + 1;
                min = Math.min(list2.get(next) - num, min);
                min = Math.min(num - list2.get(prev), min);
            }
        }

        return min;
    }


    public int shortestDistance(String[] words, String word1, String word2) {
        int i1 = -1, i2 = -1;
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < words.length; i++) {
            if (word1.equals(words[i])) {
                i1 = i;
            } else if (word2.equals(words[i])) {
                i2 = i;
            }

            if (i1 != -1 && i2 != -1) {
                res = Math.min(res, Math.abs(i2 - i1));
            }
        }

        return res;
    }
}
