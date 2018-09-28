/**
 * Created on 28 Sep 2018 by happygirlzt
 *
 * LeetCode #151. Reverse Words in a String
 */
import java.util.LinkedList;

public class ReverseWordsInAString {
    public static String reverseWords(String s) {
        String sn = s.trim();
        System.out.println(sn);

        if (sn == null || sn.length() == 0) return sn;

        String[] splitted = s.split("\\s+");

        String res = "";
        for (int i = splitted.length - 1; i >= 0; i--) {
            res += splitted[i];
            res += " ";
        }


        return res.trim();
    }

    // 别人的神奇的做法
    public String reverseWords1(String s) {
        if (s == null) return null;

        char[] a = s.toCharArray();
        int n = a.length;

        // Reverse the whole string
        reverse(a, 0, n - 1);
        // Reverse each word
        reverseWord(a, n);
        // Clean up spaces
        return cleanSpaces(a, n);
    }

    void reverseWord(char[] a, int n) {
        int i = 0, j = 0;

        while (i < n) {
            while (i < j || i < n && a[i] == ' ') i++; // skip spaces
            while (j < i || j < n && a[j] != ' ') j++; // skip non spaces
            reverse(a, i, j - 1); // reverse the word
        }
    }

    // trim leading, trailing and multiple spaces
    String cleanSpaces(char[] a, int n) {
        int i = 0, j = 0;

        while (j < n) {
            while (j < n && a[j] == ' ') j++;
            while (j < n && a[j] != ' ') a[i++] = a[j++];
            while (j < n && a[j] == ' ') j++;
            if (j < n) a[i++] = ' ';
        }

        return new String(a).substring(0, i);
    }

    // reverse a[] from a[i] to a[j]
    private void reverse(char[] a, int i, int j) {
        while (i < j) {
            char t = a[i];
            a[i++] = a[j];
            a[j--] = t;
        }
    }
    public static void main(String[] args) {
        String s = "   a   b ";
        System.out.println(reverseWords(s));
    }
}
