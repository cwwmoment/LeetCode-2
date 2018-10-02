/**
 * Created on 2 Oct 2018 by happygirlzt
 *
 * LeetCode #214. Shortest Palindrome
 */

public class ShortestPalindrome {
    // 思路1:
    // 这道题可以转变为把string s反过来加到s前面，然后求
    // 添加之后的字符串最短的回文串，当然起始index至少要在
    // s的长度那里 x 这个思路不对
    // 思路2:
    // 从string s的中间开始，然后往左边走，找到回文的中心点

    public String shortestPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        char[] cs = s.toCharArray();
        int len = cs.length;

        int mid = (0 + len - 1) >> 1;
        int left = mid
        while () {

        }
    }
}
