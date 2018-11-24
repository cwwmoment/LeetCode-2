/**
 * Created on 24 Nov 2018 by happygirlzt
 *
 * LeetCode #693. Binary Number with Alternating Bits
 *
 */

public class BinaryNumberWithAlternatingBits {
    // My slow solution
    public boolean hasAlternatingBits(int n) {
        LinkedList<Integer> list = toBinary(n);
        //System.out.println(list);

        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) == list.get(i + 1)) {
                return false;
            }
        }

        return true;
    }

    public LinkedList<Integer> toBinary(int n) {
        LinkedList<Integer> list = new LinkedList<>();
        while (n / 2 != 0) {
            list.addFirst(n % 2);
            n = n / 2;
        }

        if (n % 2 != 0) list.addFirst(n % 2);
        return list;
    }

    // Bit manipulation
    public boolean hasAlternatingBits1(int n) {
        int b = n & 1;  // n & 1 == 0, if n is even
        while ((n & 1) == b) {
            b ^= 1;
            n >>= 1; // divise n by 2
        }

        return n == 0;
    }
}
