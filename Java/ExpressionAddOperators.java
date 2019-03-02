/**
 * Created on 21 Nov 2018 by happygirlzt
 *
 * LeetCode #282. Expression Add Operators
 *
 */

public class ExpressionAddOperators {
    // backtracking
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();

        if (num == null || num.length() == 0) return res;

        helper(res, "", num, target, 0, 0, 0);

        return res;
    }

    public void helper(List<String> res, String path, String num, int target, int pos, long eval, long multed) {
        if (pos == num.length()) {
            if (target == eval)
                res.add(path);
            return;
        }

        for (int i = pos; i < num.length(); i++) {
            if (i != pos && num.charAt(pos) == '0') break;

            long cur = Long.parseLong(num.substring(pos, i + 1));

            if (pos == 0) {
                helper(res, path + cur, num, target, i + 1, cur, cur);
            } else {
                helper(res, path + "+" + cur, num, target, i + 1, eval + cur , cur);
                helper(res, path + "-" + cur, num, target, i + 1, eval - cur, -cur);
                helper(res, path + "*" + cur, num, target, i + 1, eval - multed + multed * cur, multed * cur );
            }
        }
    }
}

class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<>();
        char[] nums = num.toCharArray();
        int n = nums.length;
        char[] chars = new char[n + n]; // at most n-1 operators to insert.

        for(int j = 0, i = 0; i < n; ++i) {
            value = value * 10 + nums[i] - '0';
            chars[j++] = nums[i];
            helper(result, nums, n, i + 1, target, chars, j, 0, value); // virtual +.
            if (value == 0) { // if this is a leading 0, cannot follow any digit.
                break;
            }
        }
        return result;
    }

    // result and tail are for evaluating +-*/ on the fly.
    static void helper(List<String> results, char[] nums, int n, int i, long target,
                       char[] chars, int j, long result, long tail) {
        if (i == n) {
            if (result + tail == target) {
                results.add(String.valueOf(chars, 0, j));
            }
        } else {
            long value = 0;
            for(int op = j++, k = i; k < n; ++k) { // save the position for operator.
                value = value * 10 + nums[k] - '0';
                chars[j++] = nums[k]; // keep appending.
                chars[op] = '+';
                helper(results, nums, n, k + 1, target, chars, j, result + tail, value);
                chars[op] = '-';
                helper(results, nums, n, k + 1, target, chars, j, result + tail, -value);
                chars[op] = '*';
                helper(results, nums, n, k + 1, target, chars, j, result, tail * value);
                if (value == 0) { // leading 0
                    break;
                }
            }
        }
    }
}
