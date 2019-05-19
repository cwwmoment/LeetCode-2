/**
 * Created on 19 May 2019 by happygirlzt
 *
 * LeetCode #1047. Remove All Adjacent Duplicates In String
 *
 */

class Solution {
    public String removeDuplicates(String S) {
        Deque<Character> deque = new ArrayDeque<>();
        for (char c : S.toCharArray()) {
            if (deque.isEmpty() || deque.peekLast() != c) {
                deque.offerLast(c);
            } else {
                deque.removeLast();
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!deque.isEmpty()) {
            sb.append(deque.removeFirst());
        }

        return sb.toString();
    }
}
