/**
 * Created on 5 Dec 2018 by happygirlzt
 *
 * LeetCode #475. Heaters
 *
 */

class Heaters {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);

        int i = 0, res = 0;
        for(int house: houses){
            while(i + 1 < heaters.length && Math.abs(heaters[i] - house) >= Math.abs(heaters[i + 1] - house)){
                i++;
            }
            res = Math.max(res, Math.abs(heaters[i] - house));
        }
        return res;
    }

    // Updated on 25 Mar 2019
    public int findRadius1(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        int candidate = 0;

        for (int i = 0; i < houses.length; i++) {
            int index = Arrays.binarySearch(heaters, houses[i]);
            if (index >= 0) continue;
            // - (pos) - 1
            int pos = -(index + 1);
            int leftDis = pos > 0 ? houses[i] - heaters[pos - 1] : Integer.MAX_VALUE;
            int rightDis = pos < heaters.length ? heaters[pos] - houses[i] : Integer.MAX_VALUE;
            candidate = Math.max(candidate, Math.min(leftDis, rightDis));
        }

        return candidate;
    }
}
