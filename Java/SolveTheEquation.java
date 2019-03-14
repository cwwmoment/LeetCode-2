/**
 * Created on 14 Mar 2019 by happygirlzt
 *
 * LeetCode #640. Solve the Equation
 *
 */

class Solution {
    public String solveEquation(String equation) {
        int b = 0, y = 0, sign = 1, start = 0;
        for (int i = 0; i < equation.length(); i++) {
            if (equation.charAt(i) == '=') {
                if (start < i)
                    b += Integer.valueOf(equation.substring(start, i)) * sign;
                sign = -1;
                start = i + 1;
            } else if (equation.charAt(i) == 'x') {
                if (i == start || equation.charAt(i-1) == '+') {
                    y += sign;
                } else if (i == start || equation.charAt(i-1) == '-') {
                    y -= sign;
                } else {
                    y += Integer.valueOf(equation.substring(start, i)) * sign;
                }
                start = i + 1;
            } else if (equation.charAt(i) == '+' || equation.charAt(i) == '-') {
                if (start < i)
                    b += Integer.valueOf(equation.substring(start, i)) * sign;
                start = i;
            }
        }
        if (start < equation.length())
            b += Integer.valueOf(equation.substring(start)) * sign;
        if (b == 0 && y == 0) return "Infinite solutions";
        if (y == 0 && b != y) return "No solution";
        return "x=" + String.valueOf(-b/y);
    }
}

Copyright © 2019 LeetCode
    Help Center  |  Jobs  |  Bug Bounty  |  Terms  |  Privacy Policy     United States
