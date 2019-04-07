/**
 * Created on 27 Jan 2019 by happygirlzt
 *
 * LeetCode #158. Read N Characters Given Read4 II - Call multiple times
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
    private int tmpCnt;
    private int tmpPnt;
    private char[] tmp = new char[4];
    public int read(char[] buf, int n) {
        int total = 0;
        while (total < n) {
            if (tmpPnt == 0) {
                tmpCnt = read4(tmp);
            }

            while (total < n && tmpPnt < tmpCnt) {
                buf[total++] = tmp[tmpPnt++];
            }

            if (tmpCnt < 4) break;
            if (tmpPnt == tmpCnt) tmpPnt = 0;
        }

        return total;
    }
}
