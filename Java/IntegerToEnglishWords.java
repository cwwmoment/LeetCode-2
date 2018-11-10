/**
 * Created on 10 Nov 2018 by happygirlzt
 *
 * LeetCode #273. Integer to English Words
 *
 */

public class IntegerToEnglishWords {
    public final String[] LESS_TWENTY = {"", "One", "Two", "Three", "Four",
                                         "Five", "Six", "Seven", "Eight",
                                         "Nine", "Ten", "Elevn", "Twelve",
                                         "Thirteen", "Fourteen", "Fifteen",
                                         "Sixteen", "Seventeen", "Eighteen",
                                         "Nineteen"};
    public final String[] TENS = {"", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninty", "Hundred"};

    public final String[] THOUS = {"", "Thousand", "Million", "Billion"};

    public String numberToWords(int num) {
        String res = "";
        if (num == 0) return res;

        if (num < 1000) {
            num = num / 100;
            res += TENS[]
        }
    }
}
