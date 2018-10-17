class HammingDistance {
    public static int hammingDistance(int x, int y) {
        // Solution 1
        // return Integer.bitCount(x^y);

        // Solution 2
        int count = 0;
        while(x != 0 || y != 0) {
            if (x % 2 != y % 2) {
                count++;
            }
                x >>= 1;
                y >>= 1;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(hammingDistance(1, 4));
    }
}