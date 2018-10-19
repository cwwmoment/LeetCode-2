/**
 * Created on 17 Sep 2018 by happygirlzt
 *
 * LeetCode #45. Jump Game II
 */

public class JumpGame2 {
    public int jump (int[] nums) {
        if (nums.length == 0 || nums == null) return -1;
        if (nums.length == 1) return 0;

        int len = nums.length - 1;
        if (nums[0] >= len) return 1;

        int res = 0;
        int slow = 0, fast = 0;
        for (int i = 0; i < nums.length; i++) {
            res++;
            slow = i;
            fast = i + nums[i];
            for (int j = slow; j <= fast; j++) {

                if (j + nums[j] >= len) {

                    return ++res;
                }
            }
        }

        return res;
    }

    // Other's smart solution
    public int jump1 (int[] A) {
        int sc = 0;
        int e = 0;
        int max = 0;
        for(int i= 0; i< A.length-1; i++) {
            max = Math.max(max, i + A[i]);
            if ( i == e ) {
                sc++;
                e = max;
            }
        }
        return sc;
    }
}
