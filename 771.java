// Solution 1
class 771 {
    public static int numJewelsInStones(String J, String S) {
        int count = 0;

        for (int i = 0; i < S.length(); i++) {
            for (int j = 0; j < J.length(); j++) {
                if (S.charAt(i) == J.charAt(j)) {
                    count++;
                }
            }
        }

        return count;
    }
}

// Solution 2: HashSet
class 771 {
    public static int numJewelsInStones(String J, String S) {
        int count = 0;

        HashSet setj = new HashSet();

        for(char i : J.toCharArray()) {
            setj.add(i);
        }

        for (char j : S.toCharArray()) {
            if (setj.contains(j)) {
                count++;
            }
        }

        return count;
    }
}

// Solution 3: regex
class 771 {
    public static int numJewelsInStones(String J, String S) {
        return(S.replaceAll("[^" + J + "]", "").length());
    }
}
