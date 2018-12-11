/**
 * Created on 11 Dec 2018 by happygirlzt
 * 
 * LeetCode #829. Consecutive Numbers Sum
 * 
 */

class Solution {
    public int consecutiveNumbersSum(int N) {
        int count = 1;
        for( int k = 2; k < Math.sqrt( 2 * N ); k++ ) {
            if ( ( N - ( k * ( k - 1 )/2) ) % k == 0) {
                count++;
            }
        }
        
        return count;
    }
}