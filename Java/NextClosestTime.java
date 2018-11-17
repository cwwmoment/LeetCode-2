/**
 * Created on 17 Nov 2018 by happygirlzt
 *
 * LeetCode #681. Next Closest Time
 *
 */

public class NextClosestTime {
    public String nextClosestTime(String time) {
        char[] res = time.toCharArray();
        char[] dig = new char[] {res[0], res[1], res[3], res[4]};
        Arrays.sort(dig);

        res[4] = findNext(res[4], (char)('9' + 1), dig);
        if (res[4] > time.charAt(4)) {
            return String.valueOf(res);
        }

        res[3] = findNext(res[3], '5', dig);
        if (res[3] > time.charAt(3)) {
            return String.valueOf(res);
        }

        res[1] = res[0] == '2' ? findNext(res[1], '3', dig) :
            findNext(res[1], (char) ('9' + 1), dig);
        if (res[1] > time.charAt(1)) {
            return String.valueOf(res);
        }

        res[0] = findNext(res[0], '2', dig);
        return String.valueOf(res);
    }

    private char findNext(char cur, char upperLimit, char[] dig) {
        if (cur == upperLimit) {
            return dig[0];
        }

        int pos = Arrays.binarySearch(dig, cur) + 1;
        while (pos < 4 && (dig[pos] > upperLimit || dig[pos] == cur)) {
            pos++;
        }

        return pos == 4 ? dig[0] : dig[pos];
    }

    // Solution 2
    public String nextClosestTime2(String time) {
        char[] cs = time.toCharArray();
        char min = '9';
        for (int i = 0; i < 5; i++) {
            min = min < cs[i] ? min : cs[i];
        }

        char t = 'a';
        for (int i = 4; i >= 0; i--) {
            if (i == 2) continue;
            t = 'a';
            for (int j = 0; j < 5; j++) {
                if (j == 2 || i == j) continue;
                if (i == 3 && cs[j] > '5') continue;
                if (i == 1 && cs[0] == '2' && cs[j] > '3') continue;
                if (i == 0 && cs[j] > '2') continue;
                if (i == 0 && cs[1] > '3' && cs[j] > '1') continue;

                if (cs[j] > cs[i]) {
                    t = t < cs[j] ? t : cs[j];
                }
            }
                if (t != 'a') {
                    time = time.substring(0, i) + t + time.substring(i + 1);
                    break;
                } else {
                    time = time.substring(0, i) + min + time.substring(i + 1);
                }
        }
            return time;
    }
}
