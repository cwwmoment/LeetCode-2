/**
 * Created on 2 Dec 2018 by happygirlzt
 *
 * LeetCode #948. Bag of Tokens
 *
 */

// 不知道是不是太晚了。。导致没法思考
// 这题一开始没看懂题目。。题目描述有点奇怪
public class BagsOfTokens {
    public int bagOfTokensScore(int[] tokens, int P) {
        Arrays.sort(tokens);

        int res = 0, points = 0, left = 0, right = tokens.length - 1;

        while (left <= right) {
            if (P >= tokens[left]) {
                P -= tokens[left++];
                res = Math.max(res, ++points);
            } else if (points > 0) {
                points--;
                P += tokens[right--];
            } else {
                break;
            }
        }

        return res;
    }
}
