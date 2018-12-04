/**
 * Created on 30 Sep 2018 by happygirlzt
 *
 * LeetCode #914. X of a Kind in a Deck of Cards
 */

public class XOFAKindInADeckOfCards {
    public boolean hasGroupsSizeX(int[] deck) {
        if (deck.length == 0 || deck == null) return true;
        Arrays.sort(deck);

        int max = deck[deck.length - 1];
        int[] count = new int[max + 1];
        for (int i = 0; i < deck.length; i++) {
            count[deck[i]]++;
        }

        Arrays.sort(count);

        int start = 0;
        for (int j = 0; j < count.length; j++) {
            if (count[j] != 0) {
                start = j;
                break;
            }
        }

        int t = count[start];
        for (int k = start; k < count.length; k++) {
            if (count[k] < 2) {
                return false;
            } else if (gcd(t, count[k]) == 1 && k != start) {
                return false;
            }
        }
        return true;
    }

    public int gcd(int m, int n) {
        if (m == 0 || n == 0)
            return 0;

        if (m == n)
            return m;

        if (m > n) {
            return gcd(m - n, n);
        }

        return gcd(m, n - m);
    }

    // Updated on 4 Dec 2018, use HashMap
    public boolean hasGroupsSizeX(int[] deck) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int res = 0;
        for (int i : deck) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        for (int j : map.values()) {
            res = gcd1(j, res);
            // System.out.println("res = " + res);
        }

        return res > 1;
    }

    public int gcd1(int a, int b) {
        return b > 0 ? gcd1(b, a % b) : a;
    }
}
