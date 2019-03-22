/**
 * Created on 22 Mar 2019 by happygirlzt
 *
 * LeetCode #307. Range Sum Query - Mutable
 *
 */

class NumArray {

    private int[] BIT;
    private int[] nums;
    private int n;
    public NumArray(int[] nums) {
        n = nums.length;
        this.nums = nums;
        BIT = new int[n + 1];
        for (int i = 0; i < n; i++) {
            init(i, nums[i]);
        }
    }

    private void init(int i, int val) {
        i++;
        for(; i <= n; i += (i & -i)) {
            BIT[i] += val;
        }
    }

    public void update(int i, int val) {
        int diff = val - nums[i];
        nums[i] = val;
        init(i, diff);
    }

    public int sumRange(int i, int j) {
        return query(j + 1) - query(i);
    }

    private int query(int i) {
        int sum = 0;
        for (; i > 0; i -= i & -i) {
            sum += BIT[i];
        }
        return sum;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */
