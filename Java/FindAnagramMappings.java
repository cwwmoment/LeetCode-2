/**
 * Created on 23 Oct 2018 by happygirlzt
 *
 * LeetCode #760. Find Anagram Mappings
 *
 */

public class FindAnagramMappings {
    public int[] anagramMappings(int[] A, int[] B) {
        int len = A.length;

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < len; i++) {
            map.put(B[i], i);
        }

        int[] res = new int[len];
        int index = 0;

        for (int k : A) {
            res[index++] = map.get(k);
        }

        return res;
    }
}
