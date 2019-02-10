/**
 * Created on 10 Feb 2019 by happygirlzt
 *
 * LeetCode #881. Boats to Save People
 */

class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int count = 0;
        Arrays.sort(people);
        int lo = 0, hi = people.length - 1;
        while (lo <= hi) {
            if (people[lo] + people[hi] <= limit) {
                lo++;
                hi--;
                count++;
            } else if (people[hi] <= limit) {
                hi--;
                count++;
            }
        }
        return count;
    }
}