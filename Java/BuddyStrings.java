/**
 * Created on 7 Dec 2018 by happygirlzt
 *
 * LeetCode #859. Buddy Strings
 *
 * */

class Solution {
    // Two pointers
    public boolean buddyStrings(String a, String b) {
        if (a == null || b == null) return a.equals(b);
        if (a.length() != b.length()) return false;

        char[] ac = a.toCharArray();
        char[] bc = b.toCharArray();

        int len = a.length();

        if (len == 1) return false;
        if (a.equals(b)) {
            HashSet<Character> set = new HashSet<>();
            for (char c: ac) {
                if (set.contains(c)) return true;
                set.add(c);
            }

            return false;
        }

        int left = -1, right = -1;
        for (int i = 0; i < len; i++) {
            if (ac[i] == bc[i]) continue;
            if (left == -1) {
                left = i;
            } else if (right == -1) {
                right = i;
            } else {
                return false;
            }
        }

        if (left != -1 && right != -1) {
            return ac[left] == bc[right] && ac[right] == bc[left];
        }

        return false;
    }

    // Updated on 24 Mar 2019
    public boolean buddyStrings1(String A, String B) {
        char a = ' ', b = ' ';
        int seen = 0;
        Set<Character> set = new HashSet<>();
        boolean two = false;
        boolean flag = false;
        if (A.length() != B.length()) return false;
        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) != B.charAt(i)) {
                if (seen == 1) {
                    if (A.charAt(i) != b || B.charAt(i) != a) {
                        return false;
                    } else {
                        flag = true;
                    }
                    seen++;
                } else if (seen == 2) {
                    return false;
                } else {
                    a = A.charAt(i);
                    b = B.charAt(i);
                    seen++;
                }
            }
            if (!set.add(A.charAt(i))) two = true;
        }

        return flag || two;
    }
}
