/*
 * Created on 4 Dec 2018 by happygirlzt
 *
 * LeetCode #683. K Empty Slots
 *
 */

public class KEmptySlots {
    public int kEmptySlots(int[] flowers, int k) {
        /*
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < flowers.length; i++) {
            map.put(flowers[i], i);
        }

        HashMap<Integer, Integer> sortByLoc = map
            .entrySet()
            .stream()
            .sorted(Map.Entry.comparingByValue())
            .collect(Collectors.toMap(
            Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        int index = 0, beg = 0, end = flowers.length - 1;
        for (Map.Entr<Integer, Integer> entry : sortByLoc.entrySet()) {

        }
            return 1;
            */
        int[] loc = new int[flowers.length];

        for (int i = 0; i < flowers.length; i++) {
            loc[flowers[i] - 1] = i;
        }

        /*
        for (int j : loc) {
            System.out.println(j);
        }
        */

        int res = Integer.MAX_VALUE;
        here:
        for (int i = 0; i < flowers.length - k - 1; i++) {
            //if (loc[i] + 1 != loc[i + k + 1] &&
              // loc[i + k + 1] + 1 != loc[i]) continue;

            int max = Math.max(loc[i], loc[i + k + 1]);


            for (int j = i + 1; j <= i + k; j++) {
                if (loc[j] <= max) {
                    continue here;
                }
            }

            // System.out.println("max " + max);
            res = Math.min(max, res);
        }

        return res == Integer.MAX_VALUE ? -1 : res + 1;
    }
}
