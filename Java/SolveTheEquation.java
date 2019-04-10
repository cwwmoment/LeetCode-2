/**
 * Created on 10 Apr 2019 by happygirlzt
 *
 * LeetCode #640. Solve the Equation
 *
 */

class Solution {
    public String solveEquation(String equation) {
        int coeff = 0, sum = 0;
        int index = 0;
        int sign = 1;

        for (int i = 0; i < equation.length(); i++) {
            char c = equation.charAt(i);

            if (c == '=') {
                // 8=x
                // x=7
                if (index < i) {
                    sum += Integer.valueOf(equation.substring(index, i)) * sign;
                }

                sign = -1;
                index = i + 1;
            } else if (c == 'x') {
                // 7=x, +x
                // -x
                // 8x
                if (index == i || equation.charAt(i - 1) =='+') {
                    coeff += sign;
                } else if (equation.charAt(i - 1) == '-') {
                    coeff -= sign;
                } else {
                    coeff += Integer.valueOf(equation.substring(index, i)) * sign;
                }

                index = i + 1;
            } else if (c == '+' || c == '-') {
                // 5+7-8+6
                if (index < i) {
                    sum += Integer.valueOf(equation.substring(index, i)) * sign;
                }

                index = i;
            }
        }

        if (index < equation.length()) {
            sum += Integer.valueOf(equation.substring(index)) * sign;
        }

        if (coeff == 0 && sum == 0) {
            return "Infinite solutions";
        }

        if (coeff == 0) {
            return "No solution";
        }

        return "x=" + String.valueOf(-sum / coeff);
    }
}
