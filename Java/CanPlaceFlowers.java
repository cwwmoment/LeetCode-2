/**
 * Created on 12 Apr 2019 by happygirlzt
 *
 * LeetCode #605. Can Place Flowers
 *
 */

class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int index = 0, count = 0;
        while (index < flowerbed.length) {
            if (flowerbed[index] == 0 && (index == 0 || flowerbed[index - 1] == 0) && (index == flowerbed.length - 1 || flowerbed[index + 1] == 0)) {
                flowerbed[index] = 1;
                count++;
            }
            index++;
        }

        return count >= n;
    }
}
