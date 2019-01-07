/**
 * Created on 7 Jan 2019 by happygirlzt
 *
 * LeetCode #604. Design Compressed String Iterator
 *
 */

class StringIterator {

    private String s;
    private int count;
    private int index;
    private char ch;
    public StringIterator(String compressedString) {
        s = compressedString;
        count = 0;
        index = 0;
        ch = ' ';
    }

    public char next() {
        if (!hasNext()) return ' ';

        if (count == 0) {
            ch = s.charAt(index++);
            while (index < s.length() && Character.isDigit(s.charAt(index))) {
                count = count * 10 + s.charAt(index) - '0';
                index++;
            }
        }
        count--;
        return ch;
    }

    public boolean hasNext() {
        return index != s.length() || count != 0;
    }
}

/**
 * Your StringIterator object will be instantiated and called as such:
 * StringIterator obj = new StringIterator(compressedString);
 * char param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
