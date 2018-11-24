/**
 * Created on 24 Nov 2018 by happygirlzt
 *
 * LeetCode #244. Shortest Word Distance II
 *
 */

class WordDistance {
    private HashMap<String, List<Integer>> map;
    public WordDistance(String[] words) {
        map = new HashMap<String, List<Integer>>();
        int index = 0;
        for (String word : words) {
            if (!map.containsKey(word)) {
                List<Integer> tmp = new ArrayList<>();
                tmp.add(index);
                map.put(word, tmp);
            } else {
                map.get(word).add(index);
            }
            index++;
        }
    }

    public int shortest(String word1, String word2) {
        // return Math.abs(map.get(word1).get(0) - map.get(word2).get(0));
        List<Integer> l1 = map.get(word1);
        List<Integer> l2 = map.get(word2);
        int res = Integer.MAX_VALUE;

        for (int i = 0, j = 0; i < l1.size() && j < l2.size(); ) {
            int index1 = l1.get(i), index2 = l2.get(j);
            if (index1 < index2) {
                res = Math.min(res, index2 - index1);
                i++;
            } else {
                res = Math.min(res, index1 - index2);
                j++;
            }
        }
        return res;
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(words);
 * int param_1 = obj.shortest(word1,word2);
 */
