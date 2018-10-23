/**
 * Created on 23 Oct 2018 by happygirlzt
 *
 * LeetCode #760. Find Anagram Mappings
 *
 */

public class FindAnagramMappings {
    public int[] anagramMappings(int[] A, int[] B) {
        int len = A.length;

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < len; i++) {
            map.put(B[i], i);
        }

        int[] res = new int[len];
        int j = 0;

        for (int k : A) {
            res[j++] = map.get(k);
        }

        return res;
    }
}
