import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

public class FourSum {
	public static List<List<Integer>> fourSum(int[] nums, int target) {
		Arrays.sort(nums);

		List<List<Integer>> res = new ArrayList<List<Integer>>();

		for (int i = 0; i < nums.length; i++) {
			// if (i != 0 && nums[i] == nums[i-1]) continue;
			int j = i + 1;
			int k = nums.length - 1;
			int g = k - 1;
			int sum = 0;

			while (j < g && g < k) {
				
				sum = nums[i] + nums[j] + nums[g] + nums[k];
				System.out.println("before Sum = " + sum);
				if (sum == target) {
					res.add(Arrays.asList(nums[i], nums[j], nums[g], nums[k]));
					j++;

					while (j < g && nums[j] == nums[j-1]) j++;
				} else if (sum < target) {
					System.out.println("i = " + i + " j = " + j + " g = " + g + " k = " + k);
					System.out.println("Sum = " + sum);
					
					if (k != nums.length - 1) {
						k++;
						continue;
					} else if (k == nums.length - 1 && g + 1 != k) {
						g++;
						continue;
					} else if (k == nums.length - 1 && g + 1 == k && j + 1 != g) {
						System.out.println("I am here !");
						j++;
						// System.out.println("After  " + j);
						System.out.println("i = " + i + " j = " + j + " g = " + g + " k = " + k);
						continue;
					}
					
				} else {
					if (j + 1 == g && k != g + 1) {
						k--;					
						System.out.println("i = " + i + " j = " + j + " g = " + g + " k = " + k);
						continue;
					}
					if (j + 1 != g) {
						// System.out.println("Sum = " + sum);
						g--;
						System.out.println("i = " + i + " j = " + j + " g = " + g + " k = " + k);
						continue;
					}
				}
			}
		}

		return res;
	}

	public static void main(String[] args) {
		int[] a = { -5, 5, 4, -3, 0, 0, 4, -2 };
		System.out.println(fourSum(a, 4));
	}
}
