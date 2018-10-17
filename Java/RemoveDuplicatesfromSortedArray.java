import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicatesfromSortedArray {
	
	public static int removeDuplicates(int[] nums) {
		if (nums == null || nums.length == 0) return 0;
		if (nums.length == 1) return 1;
		
		Set<Integer> set = new HashSet<>();
		
		for (int i = 0; i < nums.length; i ++) {
			while(set.add(nums[i])) {
				nums[set.size()-1] = nums[i];
			}
		}
		System.out.println("The size of set is " + set.size());
		nums = Arrays.copyOf(nums, set.size());
		
		return nums.length;
	}
	
	public static int removeDuplicates2(int[] nums) {
		if (nums == null || nums.length == 0) return 0;
		if (nums.length == 1) return 1;
		
		int i = 0;
		for (int j = i + 1; j < nums.length; j++) {
			if (nums[i] != nums[j]) {
				i++;
				nums[i] = nums[j];
			}
		}
		
		return ++i;
	}
	
	public static void main(String[] args) {
		int[] test = {1,1,2};
		int res = removeDuplicates(test);
		
		for (int i = 0; i < res; i++) {
			System.out.println(test[i]);
		}
	}
}
