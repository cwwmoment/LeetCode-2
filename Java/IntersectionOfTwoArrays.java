/**
 * Created on 7 Oct 2018 by happygirlzt
 *
 * LeetCode 349. Intersection of Two Arrays
 */

public class IntersectionOfTwoArrays {
    // 难怪这题被投了这么多反对票，题意有问题
    // 我也以为这道题是求连续的最长的子数组
    // 其实只是求两个数组相同的值而已
    // 复杂度为O(n)
    public int[] intersection(int[] n1, int[] n2) {
        int len1 = n1.length;
        int len2 = n2.length;

        HashSet<Integer> set1 = new HashSet<>();

        for (int i = 0; i < len1; i++) {
            set1.add(n1[i]);
        }

        System.out.println(map);

        HashSet<Integer> res = new HashSet<>();
        for (int j = 0; j < len2; j++) {
            if (set1.contains(n2[j])) {
                res.add(n2[j]);
            }
        }

        int[] r = new int[res.size()];
        int index = 0;
        for (Integer i : res) {
            r[index++] = i;
        }

        return r;
    }

    // Solution 1: O(nlogn)
    // Two pointers
    public int[] intersection1(int[] n1, int[] n2) {
        Set<Integer> set = new HashSet<>();
        Arrays.sort(n1);
        Arrays.sort(n2);

        int i = 0;
        int j = 0;
        while (i < n1.length && j < n2.length) {
            if (n1[i] < n2[j]) {
                i++;
            } else if (n1[i] > n2[j]) {
                j++;
            } else {
                set.add(n1[i]);
                i++;
                j++;
            }
        }

        int[] res = new int[set.size()];
        int k = 0;
        for (Integer num : set) {
            res[k++] = num;
        }

        return res;
    }

    // Binary search O(nlogn)
    public int[] intersection2(int[] n1, int[] n2) {
        Set<Integer> set = new HashSet<>();
        Arrays.sort(n2);
        for (Integer num : n1) {
            if (binarySearch(n2, num)) {
                set.add(num);
            }
        }

        int i = 0;
        int[] res = new int[set.size()];
        for (Integer num : set) {
            res[i++] = num;
        }

        return res;
    }

    public boolean binarySearch(int[] n, int num) {
        int left = 0, right = n.length - 1;

        while (left <= right) {
            int mid = (left + right) >> 1;
            if (n[mid] == num) {
                return true;
            } else if (n[mid] > num) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return false;
    }
}
