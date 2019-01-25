/**
 * Created on 3 Nov 2018 by happygirlzt
 *
 * LeetCode #LeetCode 127 Word Ladder
 *
 */

public class WordLadder {
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        if(beginWord.equals(endWord)) return 1;
        Set<String> set = new HashSet<>(wordList);
        Queue<String> q = new LinkedList<>();

        int len = 2;
        q.offer(beginWord);

        while(!q.isEmpty()){
            int size = q.size();

            for(int i = 0; i < size; i++){
                String cur = q.poll();

                for(int j = 0; j < cur.length(); j++){
                    StringBuilder sb = new StringBuilder(cur);

                    for(char c = 'a'; c <= 'z'; c++){
                        sb.setCharAt(j, c);
                        String tmp = sb.toString();

                        if(set.contains(tmp)){
                            if(tmp.equals(endWord)) return len;

                            q.offer(tmp);
                            set.remove(tmp);
                        }
                    }
                }
            }
            len++;
        }
        return 0;
    }

    // Updated on 25 Jan 2019
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> unvisited = new HashSet(wordList);
        Queue<String> q = new LinkedList<>();

        if (!unvisited.contains(endWord)) return 0;
        q.offer(beginWord);
        unvisited.remove(beginWord);

        int distance = 2;
        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                StringBuilder curWord = new StringBuilder(q.poll());
                for (int j = 0; j < curWord.length(); j++) {
                    char tmp = curWord.charAt(j);
                    for (int k = 0; k < 26; k++) {
                        curWord.setCharAt(j, (char) ('a' + k));

                        if (unvisited.contains(curWord.toString())) {
                            if (curWord.toString().equals(endWord)) {
                                return distance;
                            } else {
                                unvisited.remove(curWord.toString());
                                //visited.add(curWord.toString());
                                q.offer(curWord.toString());
                            }
                        }
                        curWord.setCharAt(j, tmp);
                    }
                }
            }

            distance++;
        }

        return 0;
    }
}
