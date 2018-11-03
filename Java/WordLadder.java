/**
 * Created on 3 Nov 2018 by happygirlzt
 *
 * LeetCode #LeetCode 127 Word Ladder
 *
 */
// 这是一道经典的BFS题，问题在于你要看出来这是bfs
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
                            if(tmp.equals(endWord)) return len;//endword need to be in dict
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
}
