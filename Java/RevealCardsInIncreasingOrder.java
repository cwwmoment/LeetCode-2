/**
 * Created on 29 Apr 2019 by happygirlzt
 *
 * LeetCode #950. Reveal Cards In Increasing Order
 *
 */

class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        Deque<Integer> q = new LinkedList<>();
        int n = deck.length;
        for (int i = 0; i < n; i++) {
            q.offer(i);
        }

        int[] res = new int[n];
        for (int i : deck) {
            res[q.pollFirst()] = i;
            if (!q.isEmpty()) {
                q.offer(q.pollFirst());
            }
        }

        return res;
    }
}
