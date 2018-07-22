import java.util.Arrays;
import java.util.HashMap;

public class SingleNumber2 {
	public static int solution(int[] nums) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(nums[i]) == false) {
				map.put(nums[i], 1);
			} else {
				map.put(nums[i], map.get(nums[i])+1);
			}
		}
		
		// System.out.print(Arrays.asList(map));
		int res = 0;
		for (Integer i : map.keySet()) {
			// System.out.println(i);
			if (map.get(i).equals(1)) {
				res = i;
			}
		}
		
		return res;
	}
	
	public static void main(String[] args) {
		int[] b = {0,1,0,1,0,1,99};
		System.out.println(solution(b));
	}
}
