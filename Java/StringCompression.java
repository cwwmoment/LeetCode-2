/**
 * Created on 10 Jan 2019 by happygirlzt
 *
 * LeetCode #443. String Compression
 *
 */

class Solution {
    public int compress(char[] chars) {
        if (chars == null || chars.length == 0) return 0;
        int num = 1;
        int index = 0;

        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == chars[i - 1]) {
                num++;
            } else {
                chars[index++] = chars[i - 1];
                if (num == 1) continue;
                for (char digit : String.valueOf(num).toCharArray()) {
                    chars[index++] = digit;
                }
                num = 1;
            }
        }

        if (num != 0) {
            chars[index++] = chars[chars.length - 1];
            if (num != 1) {
                for (char digit : String.valueOf(num).toCharArray()) {
                    chars[index++] = digit;
                }
            }
        }

        return index;
    }
}
