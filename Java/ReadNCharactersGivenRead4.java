/**
 * Created on 27 Jan 2019 by happygirlzt
 *
 * LeetCode #157. Read N Characters Given Read4
 *
 */

/**
 * The read4 API is defined in the parent class Reader4.
 *     int read4(char[] buf);
 */
public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    public int read(char[] buf, int n) {
        char[] tmp = new char[4];

        int count = 0, index = 0;
        while (n > 0) {
            count = read4(tmp);
            int len = Math.min(count, n);
            System.arraycopy(tmp, 0, buf, index, len);

            index += len;
            n -= len;
            if (count < 4) return index;
        }

        return index;
    }
}
}
