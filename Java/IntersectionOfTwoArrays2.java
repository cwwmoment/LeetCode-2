/**
 * Created on 21 Dec 2018 by happygirlzt
 *
 * LeetCode #350. Intersection of Two Arrays II
 *
 */

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> res = new ArrayList<>();
        int i = 0, j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                res.add(nums2[j]);
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }

        int[] result = new int[res.size()];
        int index = 0;
        for (int item : res) {
            result[index++] = item;
        }

        return result;

    }
}
