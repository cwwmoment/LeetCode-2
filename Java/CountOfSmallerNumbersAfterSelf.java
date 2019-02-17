import com.sun.tools.doclets.internal.toolkit.taglets.ReturnTaglet;

/**
 * Created on 17 Feb 2019 by happygirlzt
 * 
 * LeetCode #315. Count of Smaller Numbers After Self
 * 
 */

 class Solution {
     public List<Integer> countSmaller(int[] nums) {
         List<Integer> res = new ArrayList<>();
         int[] count = new int[nums.length];
         int[] index = new int[nums.length];
         for (int i = 0; i < nums.length; i++) {
             index[i] = i;
         }
         mergeSort(nums, index, 0, nums.length - 1);
         for (int i : count) {
             res.add(i);
         }
         return res;
     }

     private void mergeSort(int[] nums, int[] index, int l, int r, int[] count) {
         if (l >= r) return;
         int mid = (r - l) / 2 + l;
         mergeSort(nums, index, l , mid, count);
         mergeSort(nums, index, mid + 1, r, count);
         merge(nums, index, l, r, count);
     }

     private void merge(int[] nums, int[] index, int start, int end, int[] count) {
         int mid = (end - start) / 2 + start;
         int l = start, r = mid + 1;
         int i = 0, rightCounter = 0;
         int[] newIndex = new int[end - start + 1];
         while (l <= mid && r <= end) {
             if (nums[index[r]] < nums[index[l]]) {
                 newIndex[i] = index[r];
                 rightCounter++;
                 r++;
             } else {
                 newIndex[i] = index[l];
                 count[index[l]] += rightCounter;
                 l++;
             }
             i++;
         }

         while (l <= mid) {
             newIndex[i] = index[l];
             count[index[l]] += rightCounter;
             l++;
             i++;
         }

         while (r <= end) {
             newIndex[i] = index[r];
             r++;
             i++;
         }

         for (int j = start; j <= end; j++) {
             index[j] = newIndex[j - start];
         }
     }
 }