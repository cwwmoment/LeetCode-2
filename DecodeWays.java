/**
 * Created on 27 Sep 2018 by happygirlzt
 *
 * LeetCode #91. Decode Ways
 */

public class DecodeWays {
    // My buggy solution
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) return 0;

        int res = 0;
        int len = s.length();

        if (len == 1) return Integer.parseInt(s) > 0 ? 1 : 0;

        char[] cs = s.toCharArray();
        boolean flag = false;


        if (check(cs, 0, len - 1)) {
            System.out.println("hhhh");
            res++;
        }

        if (len > 2) {
            if (check(cs, 0, 0) && check(cs, 1, len - 1)) {
                res++;
            }
        }

        res++;
        for (char c : cs) {
            if (Character.getNumericValue(c) == 0) {
                res--;
                break;
            }
        }
        return res;
    }

    public boolean check (char[] cs, int left, int right) {
        if (right == left + 1) {
            if (Character.getNumericValue(cs[left]) > 0 && Character.getNumericValue(cs[left]) <= 2 && Character.getNumericValue(cs[right]) <= 6) {
                return true;
            } else {
                return false;
            }
        } else if (right == left) {
            System.out.println(Character.getNumericValue(cs[right]));
            return Character.getNumericValue(cs[right]) == 0 ? false : true;
        } else {
            return check(cs, left, left + 1) && check(cs, left + 2, right);
        }
    }

    // Other's smart solution
    public int numDecodings(String s) {
        int n = s.length();
        if (n == 0) return 0;

        int[] memo = new int[n+1];
        memo[n]  = 1;
        memo[n-1] = s.charAt(n-1) != '0' ? 1 : 0;

        for (int i = n - 2; i >= 0; i--)
            if (s.charAt(i) == '0') continue;
            else memo[i] = (Integer.parseInt(s.substring(i,i+2))<=26) ? memo[i+1]+memo[i+2] : memo[i+1];

        return memo[0];
    }
}
