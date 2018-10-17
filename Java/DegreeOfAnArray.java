/**
 * Created on 25 Sep 2018 by happygirlzt
 *
 * LeetCode #697. Degree of an Array
 */

public class DegreeOfAnArray {

    // 我的解法，其实思路很不错啦，就是代码不太精简
    public int findShortestSubArray(int[] nums) {
        int len = nums.length;
        if (len == 0) return 0;
        HashMap<Integer, ArrayList> map = new HashMap<>();

        int maxFre = 0;
        int res = 1;
        for (int i = 0; i < len; i++) {
            if (map.containsKey(nums[i])) {
                ArrayList<Integer> tmp = map.get(nums[i]);
                tmp.add(i);
                map.put(nums[i], tmp);
                int size = map.get(nums[i]).size();
                if (size > maxFre) {
                    res = tmp.get(size - 1) - tmp.get(0) + 1;
                    maxFre = size;
                } else if (size == maxFre) {
                    int t = tmp.get(size - 1) - tmp.get(0) + 1;
                    res = Math.min(res, t);
                    maxFre = size;
                }
            } else {
                ArrayList<Integer> tmp = new ArrayList<>();
                tmp.add(i);
                map.put(nums[i], tmp);
            }
        }

        return res;
    }

    // 修改一下我的解法
    public int findShortestSubArray0(int[] nums) {
        int len = nums.length;
        // corner case
        if (len == 0) return 0;
        HashMap<Integer, ArrayList> map = new HashMap<>();

        int degree = 0, res = 1;
        for (int i = 0; i < len; i++) {
            map.p
        }
    }
    // 别人很精炼的写法
    public int findShortestSubArray1(int[] nums) {
        Map<Intger, Integer> counter = new HashMap<>(), first = new HashMap<>();
        int res = 0, degree = 0;

        for (int i = 0; i < nums.length; i++) {
            // 省去了containsKey的过程
            first.putIfAbsent(nums[i], i);
            // 如果已经存在
            counter.put(nums[i], counter.getOrDefault(nums[i], 0) + 1);
            if (counter.get(nums[i]) > degree) {
                degree = counter.get(nums[i]);
                res = i - first.get(nums[i]) + 1;
            } else if (counter.get(nums[i]) == degree) {
                res = Math.min(res, i - first.get(nums[i]) + 1);
            }
        }

        return res;
    }
}
