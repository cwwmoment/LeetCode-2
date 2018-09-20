/**
 * LeetCode 162. Find Peak Element
 *
 * @author happygirlzt Updated on 20 Sep 2018
 *
 */
public class FindPeakElement {
    // My naive solution
    public static int findPeakElement1(int[] nums) {

        int left = 0, right = nums.length - 1;
        while (left < right) {
            if (nums[left] < nums[left + 1]) {
                left++;
            } else if (nums[left] > nums[left + 1]){
                return left;
            }

            if (nums[right] < nums[right - 1]) {
                right--;
            } else if (nums[right] > nums[right - 1]) {
                return right;
            }
        }

        return left;
    }

    // Binary Search solution
    public static int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 1};

        System.out.println(findPeakElement(a));
    }
}
