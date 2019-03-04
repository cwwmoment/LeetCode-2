/**
 * Created on 12 Dec 2018 by happygirlzt
 *
 * LeetCode #394. Decode String
 *
 */

class Solution {
    private int i = 0;
    public String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        int num = 0;

        for (; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '[') {
                i++;
                String str = decodeString(s);
                for (int k = 0; k < num; k++) {
                    sb.append(str);
                }
                num = 0;
            } else if (c == ']') {
                return sb.toString();
            } else if (c >= '0' && c <= '9') {
                num = num * 10 + c - '0';
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }

    // Updated on 4 Mar 2019
    public String decodeString1(String s) {
        Deque<Integer> numStack = new ArrayDeque<>();
        Deque<String> strStack = new ArrayDeque<>();
        int num = 0;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = c - '0';
                while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
                    num = num * 10 + s.charAt(i + 1) - '0';
                    i++;
                }

                numStack.push(num);
                num = 0;
            } else if (c == '[') {
                strStack.push(sb.toString());
                sb = new StringBuilder();
            } else if (c == ']') {
                StringBuilder tmp = new StringBuilder(strStack.pop());
                int times = numStack.pop();
                for (int j = 0; j < times; j++) {
                    tmp.append(sb);
                }

                sb = tmp;
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }
}
