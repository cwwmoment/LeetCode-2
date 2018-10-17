
import java.util.HashMap;

class TwoSum {
	// naive solution
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

    // 16 Aug 2018 HashMap
    public static int[] solution2(int[] nums, int target) {
    	HashMap<Integer, Integer> map = new HashMap<>();
    	
    	for (int i = 0; i < nums.length; i++) {
    		if (map.containsKey(target - nums[i])) {
    			return (new int[]{i, map.get(target-nums[i])});
    		} else {
    			map.put(nums[i], i);
    		}
    	}
    	
    	return new int[]{0, 0};
    }
    
    public static void main(String[] args) {
        int[] a = {2, 7, 11, 15};
        int tar = 9;

        System.out.println(Solution(a, tar));
    }
}
