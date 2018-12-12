/**
 * Created on 12 Dec 2018 by happygirlzt
 *
 * LeetCode #8. String to Integer (atoi)
 *
 */

// Note: Double has larger scope than long
class Solution {
    public int myAtoi(String str) {
          if (str == null) return 0;
          double res = 0; // double's scope is larger than long!!
          int i = 0;
           // handle the leading whitespace
          while (i < str.length() && str.charAt(i) == ' ') {
               i++;
           }
          // if the str only contains whitespace
         if (i >= str.length()) return 0;

         // the first non-whitespace character is not digit
         // nor sign
         char sign = '+';
         if (!Character.isDigit(str.charAt(i))) {
             if (str.charAt(i) == '+') {
                i++;
             } else if (str.charAt(i) == '-') {
                sign = '-';
                i++;
             } else {
                 return 0;
             }
         }
         // now i is the first digit char
          while (i < str.length() && Character.isDigit(str.charAt(i))) {
            res = res * 10 + str.charAt(i) - '0';
              i++;
         }

         if (sign == '-') res = -res;
         if (res > Integer.MAX_VALUE) {
              res = Integer.MAX_VALUE;
         } else if (res < Integer.MIN_VALUE) {
              res = Integer.MIN_VALUE;
         }

         return (int) res;

    }
}
