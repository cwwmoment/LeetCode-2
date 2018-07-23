import java.util.*;

class UniqueMorse {
    public static int uniqueMorseRepresentations(String[] words) {
        Map<Character, String> map = new HashMap<Character, String>();

        String[] morse = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};

        int i = 0;
        for (char ch = 'a'; ch <= 'z'; ch++) {
            map.put(ch, morse[i]);
            i++;
        }

        HashMap<String, String> morseRe = new HashMap<>();

        int len = words.length;
        String[] morsed = new String[len];

        for (int j = 0; j < len; j++) {
            char[] array = words[j].toCharArray();

            for (char z : array) {
                morsed[j] += map.get(z);
            }
        }

        HashSet set = new HashSet();
        for (int k = 0; k < len; k++) {
            set.add(morsed[k]);
        }

        return set.size();
    }

    public static int solution2(String[] words) {
        String[] morse = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};

        HashSet<String> mySet = new HashSet<String>();

        for (String word : words) {
            String code = "";

            for (char i : word.toCharArray()) {
                code += morse[ i - 'a'];
            }

            mySet.add(code);
        }

        return mySet.size();
    }

    public static void main(String[] agrs) {
        String[] words = {"gin", "zen", "gig", "msg"};
        System.out.println(uniqueMorseRepresentations(words));
    }
}
