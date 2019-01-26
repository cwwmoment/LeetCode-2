/**
 * Created on 26 Jan 2019 by happygirlzt
 *
 * LeetCode #825. Friends Of Appropriate Ages
 *
 */

class Solution {
    public int numFriendRequests(int[] ages) {
        int[] count = new int[121];
        for (int age : ages) {
            count[age]++;
        }

        int res = 0;
        for (int ageA = 1; ageA <= 120; ageA++) {

            for (int ageB = 1; ageB <= 120; ageB++) {
                if (ageA * 0.5 + 7 >= ageB) continue;
                if (ageA < ageB) continue;
                if (ageA < 100 && ageB > 100) continue;

                res += count[ageA] * count[ageB];
                if (ageA == ageB) res -= count[ageA];
            }
        }

        return res;
    }
}
