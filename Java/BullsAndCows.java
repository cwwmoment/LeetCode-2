/**
 * Created on 29 Nov 2018 by happygirlzt
 *
 * LeetCode #299. Bulls and Cows
 *
 */

public class BullsAndCows {
    public String getHint(String secret, String guess) {
        int a = 0, b = 0;

        int len = secret.length();
        char[] sc = secret.toCharArray(), gc = guess.toCharArray();
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();

        for (int i = 0; i < len; i++) {
            if (sc[i] == gc[i]) {
                a++;
            } else {
                map1.put(sc[i], map1.getOrDefault(sc[i], 0) + 1);
                map2.put(gc[i], map2.getOrDefault(gc[i], 0) + 1);
            }
        }

        for (Map.Entry<Character, Integer> entry : map1.entrySet()) {
            if (map2.containsKey(entry.getKey())) {
                b += Math.min(entry.getValue(), map2.get(entry.getKey()));
            }
        }

        StringBuilder sb = new StringBuilder();
        // sb.append((char) (a + '0'));
        sb.append(String.valueOf(a));
        sb.append('A');
        // sb.append((char) (b + '0'));
        // Have bug?
        sb.append(String.valueOf(b));
        sb.append("B");

        return sb.toString();
    }

    // Other's one-pass solution
    public String getHint1(String secret, String guess) {
        int bulls = 0;
        int cows = 0;
        int[] numbers = new int[10];
        for (int i = 0; i < secret.length(); i++) {
            int s = Character.getNumericValue(secret.charAt(i));
            int g = Character.getNumericValue(guess.charAt(i));
            if (s == g) bulls++;
            else {
                if (numbers[s] < 0) cows++;
                if (numbers[g] > 0) cows++;
                numbers[s] ++;
                numbers[g] --;
            }
        }
        return bulls + "A" + cows + "B";
    }
}
