/**
 * LeetCode #455. Assign Cookies
 *
 * Created by happygirlzt on 13 Sep 2018
 */

public class AssignCookies {
    public int findContentChildren(int[] g, int[] s) {
        if (g.length == 0 || s.length == 0 || g == null || s == null) return 0;
        int res = 0;

        Arrays.sort(s);
        int cs = s.length;  // cookies num
        Arrays.sort(g);
        int gs = g.length;  // greed factores num

        if (s[cs - 1] < g[0]) return 0;
        int start1 = cs - 1;
        int start2 = gs - 1;

        for (int i = start1; i >= 0; i--) {
            for (int j = start2; j >= 0; j--) {
                if (s[i] >= g[j]) {
                    res++;
                    start1 = i - 1;
                    start2 = j - 1;
                    break;
                }
            }
        }

        return res >= gs ? gs : res;
    }
}
