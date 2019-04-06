/**
 * Created on 25 Dec 2018 by happygirlzt
 *
 * LeetCode #163. Missing Ranges
 *
 */

class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<>();

        if (nums == null || nums.length == 0) {
            if (lower == upper) {
                res.add(lower + "");
                return res;
            }
            res.add(lower + "->" + upper);
            return res;
        }

        if (nums[0] > lower) {
            int high = nums[0] - 1;
            if (lower == high) {
                res.add(lower + "");
            } else
                res.add(lower + "->" + high);
        }

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1] || nums[i] + 1 == nums[i + 1]) continue;
            if (nums[i] + 1 == nums[i + 1] - 1) {
                res.add(nums[i] + 1 + "");
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append(nums[i] + 1);
                sb.append("->");
                sb.append(nums[i + 1] - 1);
                res.add(sb.toString());
            }
        }
        if (nums[nums.length - 1] < upper) {
            int low = nums[nums.length - 1] + 1;
            if (low == upper) {
                res.add(low + "");
            } else {
                res.add(low + "->" + upper);
            }
        }

        return res;
    }

    // Other's solution
    public List<String> findMissingRanges1(int[] a, int lo, int hi) {
        List<String> res = new ArrayList<String>();

        int next = lo;

        for (int i = 0; i < a.length; i++) {
            // not within the range yet
            if (a[i] < next) continue;

            // continue to find the next one
            if (a[i] == next) {
                next++;
                continue;
            }

            // get the missing range string format
            res.add(getRange(next, a[i] - 1));

            // now we need to find the next number
            next = a[i] + 1;
        }

        // do a final check
        if (next <= hi) res.add(getRange(next, hi));

        return res;
    }

    String getRange(int n1, int n2) {
        return (n1 == n2) ? String.valueOf(n1) : String.format("%d->%d", n1, n2);
    }

    // Updated on 6 Apr 2019
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        long l = (long) lower;
        long u = (long) upper;
        List<String> res = new ArrayList<>();
        int n = nums.length;

        if (n == 0) {
            add(res, l - 1, u + 1);
            return res;
        }

        add(res, l - 1, nums[0]);
        for (int i = 1; i < n; i++) {
            add(res, nums[i - 1], nums[i]);
        }
        add(res, nums[n - 1], u + 1);
        return res;
    }

    private void add(List<String> res, long lo, long hi) {
        if (lo == hi) {
            return;
        } else if (lo + 1 == hi) {
            return;
        } else if (lo + 1 == hi - 1) {
            res.add(String.valueOf(lo + 1));
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append(String.valueOf(lo + 1));
            sb.append("->");
            sb.append(String.valueOf(hi - 1));
            res.add(sb.toString());
        }
    }
}
