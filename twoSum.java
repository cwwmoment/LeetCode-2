import java.util.Arrays;

class TwoSum {
    public static int[] Solution(int[] nums, int target) {
        // Arrays.sort(nums);

        int[] res = new int[2];

        for(int i = 0; i < nums.length; i++) {  // foreach i in nums
            int j = target - nums[i];
            for(int z = i + 1; z < nums.length; z++) {
                if (nums[z] == j) {
                    res[0] = i;
                    res[1] = z;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] a = {2, 7, 11, 15};
        int tar = 9;

        System.out.println(Solution(a, tar));
    }
}
