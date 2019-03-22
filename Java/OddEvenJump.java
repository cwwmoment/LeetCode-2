/**
 * Created on 20 Mar 2019 by happygirlzt
 *
 * LeetCode #975. Odd Even Jump
 *
 */

class Solution {
    public int oddEvenJumps(int[] A) {
        int N = A.length;
        boolean[] odd = new boolean[N];
        boolean[] even = new boolean[N];
        odd[N - 1] = true;
        even[N - 1] = true;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(A[N - 1], N - 1);

        for (int i = N - 2; i >= 0; i--) {
            int num = A[i];
            Integer lower = map.floorKey(num);
            Integer higher = map.ceilingKey(num);

            if (lower != null) {
                even[i] = odd[map.get(lower)];
            }

            if (higher != null) {
                odd[i] = even[map.get(higher)];
            }

            map.put(A[i], i);
        }

        int count = 0;
        for (boolean val : odd) {
            if (val) count++;
        }
        return count;
    }
}
