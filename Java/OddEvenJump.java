/**
 * Created on 20 Mar 2019 by happygirlzt
 *
 * LeetCode #975. Odd Even Jump
 *
 */

class Solution {
    public int oddEvenJumps(int[] A) {
        int n = A.length;
        if(n < 2) return n;
        int[] higher = new int[n];
        Arrays.fill(higher,-1);
        int[] lower = new int[n];
        Arrays.fill(lower,-1);

        TreeMap<Integer,Integer> map= new TreeMap<>();
        map.put(A[n-1],n-1);
        higher[n - 1] = 1;
        lower[n - 1] = 1;

        for (int i = n - 2; i > -1; i--) {
            Map.Entry hi= map.ceilingEntry(A[i]);
            Map.Entry lo= map.floorEntry(A[i]);
            if (hi!=null) higher[i] = lower[(int)hi.getValue()];
            if (lo!=null) lower[i] = higher[(int)lo.getValue()];
            map.put(A[i],i);
        }

        int ans = 0;
        for (int x: higher)
            if(x == 1) ans++;
        return ans;
    }
}
