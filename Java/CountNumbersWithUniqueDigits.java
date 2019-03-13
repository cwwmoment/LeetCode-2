/**
 * Created on 13 Mar 2019 by happygirlzt
 *
 * LeetCode #357. Count Numbers with Unique Digits
 *
 */

class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) {
            return 1;
        }

        int res = 10;
        int uniqueDigits = 9;
        int availableNumber = 9;
        while (n-- > 1 && availableNumber > 0) {
            uniqueDigits = uniqueDigits * availableNumber;
            res += uniqueDigits;
            availableNumber--;
        }

        return res;
    }
}
