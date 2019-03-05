/**
 * Created on 27 Nov 2018 by happygirlzt
 *
 * LeetCode #269. Alien Dictionary
 *
 */
//visited status
//-1    : not exit
//0     : not visited
//1     : visiting
//2     : visited
public class AlienDictionary {
    private final int N = 26;
    public String alienOrder1(String[] words) {
        boolean[][] adj = new boolean[N][N];
        int[] visited = new int[N];
        buildGraph(words, adj, visited);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            if (visited[i] == 0) {
                if (!dfs(adj, visited, sb, i)) return "";
            }
        }
        return sb.reverse().toString();
    }

    public boolean dfs(boolean[][] adj, int[] visited, StringBuilder sb, int i) {
        visited[i] = 1;
        for (int j = 0; j < N; j++) {
            if (adj[i][j]) {
                if(visited[j] == 1) return false;
                if(visited[j] == 0) {
                    if(!dfs(adj, visited, sb, j)) return false;
                }
            }
        }
        visited[i] = 2;
        sb.append((char) (i + 'a'));
        return true;
    }

    public void buildGraph(String[] words, boolean[][] adj, int[] visited) {
        Arrays.fill(visited, -1);

        for(int i = 0; i < words.length; i++) {
            for(char c : words[i].toCharArray()) visited[c - 'a'] = 0;
            if (i > 0) {
                String w1 = words[i - 1], w2 = words[i];

                int len = Math.min(w1.length(), w2.length());
                for (int j = 0; j < len; j++) {
                    char c1 = w1.charAt(j), c2 = w2.charAt(j);
                    if (c1 != c2) {
                        adj[c1 - 'a'][c2 - 'a'] = true;
                        break;
                    }
                }
            }
        }
    }

       // Solution 2
       public String alienOrder2(String[] words) {
        if (words == null || words.length == 0) return "";
        //Get degrees
        int[] degrees = new int[26];
        for (String word : words) {
            for (char ch : word.toCharArray()) degrees[ch - 'a'] = 1;
        }

        int count = 0;

        for (int degree: degrees) {
            if (degree == 1)  {
                count++;
            }
        }

        //Populate map with char as the key and set of following chars as the value
        Map<Character, Set<Character>> map = new HashMap<>();
        for (int i = 0; i < words.length - 1; i++) {
            String cur = words[i], next = words[i + 1];
            int min = Math.min(cur.length(), next.length());
            for (int j = 0; j < min; j++) {
                char c1 = cur.charAt(j), c2 = next.charAt(j);
                if (c1 != c2) {
                    Set<Character> set = map.getOrDefault(c1, new HashSet<>());
                    if (set.add(c2)) {
                        degrees[c2 - 'a']++;
                        map.put(c1, set);
                    }
                    break; //We just need the first different character
                }
            }
        }
        //Topological sort
        Queue<Character> q = new LinkedList<>();
        for (int i = 0; i < 26; i++) {
            if (degrees[i] == 1) q.offer((char) (i + 'a'));
        }
        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            char cur = q.poll();
            sb.append(cur);
            for (char ch : map.getOrDefault(cur, new HashSet<>())) {
                if (--degrees[ch - 'a'] == 1) q.offer(ch);
            }
        }
        return sb.length() == count ? sb.toString() : "";
    }

    // Updated on 9 Feb 2019
    public String alienOrder3(String[] words) {
        Map<Character, Set<Character>> graph = new HashMap<>();
        int[] inDegree = new int[26];
        buildGraph(graph, inDegree, words);
        return bfs(graph, inDegree);
    }

    private void buildGraph(Map<Character, Set<Character>> graph, int[] inDegree, String[] words) {
        // !!! Attention: 这个地方一定要先把所有出现的char放到graph里，
        // 这样才能完全涵盖所有的char
        for (String s : words) {
            for (char c : s.toCharArray()) {
                graph.putIfAbsent(c, new HashSet<>());
            }
        }

        for (int i = 1; i < words.length; i++) {
            String first = words[i - 1];
            String second = words[i];
            int len = Math.min(first.length(), second.length());
            for (int j = 0; j < len; j++) {
                char out = first.charAt(j);
                char in = second.charAt(j);
                if (out != in) {
                    if (!graph.get(out).contains(in)) {
                        graph.get(out).add(in);
                        inDegree[in - 'a']++;
                    }
                    break;
                }
            }
        }
    }

    private String bfs(Map<Character, Set<Character>> graph, int[] inDegree) {
        StringBuilder sb = new StringBuilder();
        Queue<Character> q = new LinkedList<>();
        for (char c : graph.keySet()) {
            if (inDegree[c - 'a'] == 0) {
                q.offer(c);
            }
        }

        while (!q.isEmpty()) {
            char out = q.poll();
            sb.append(out);
            for (char in : graph.get(out)) {
                inDegree[in - 'a']--;
                if (inDegree[in - 'a'] == 0) {
                    q.offer(in);
                }
            }
        }

        return sb.length() == graph.size() ? sb.toString() : "";
    }
}
