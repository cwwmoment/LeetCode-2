/**
 *
 * Created on 10 Dec 2018 by happygirlzt
 * 
 * LeetCode #734. Sentence Similarity
 * 
 */ 
 
 class Solution {
    public boolean areSentencesSimilar(String[] words1, String[] words2, String[][] pairs) {
        if (words1.length != words2.length || words1 == null || words2 == null) return false;
        
        Set<String> set = new HashSet<>();
        
        for (String[] pair : pairs) {
            set.add(pair[0] + "#" + pair[1]);
        }
        
        for (int i = 0; i < words1.length; i++) {
            if (!words1[i].equals(words2[i]) && !set.contains(words1[i] + '#' + words2[i]) &&
               !set.contains(words2[i] + '#' + words1[i])) return false;
        }
        return true;
    }
}