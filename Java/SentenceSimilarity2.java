/**
 * Created on 19 Dec 2018 by happygirlzt
 *
 * LeetCode #737. Sentence Similarity II
 *
 */

// DFS
class Solution {
    public boolean areSentencesSimilarTwo(String[] words1, String[] words2, String[][] pairs) {
        if (words1.length != words2.length) return false;
        // use a map as graph
        Map<String, Set<String>> graph = new HashMap<>();

        for (String[] pair : pairs) {
            graph.putIfAbsent(pair[0], new HashSet<String>());
            graph.putIfAbsent(pair[1], new HashSet<String>());
            graph.get(pair[0]).add(pair[1]);
            graph.get(pair[1]).add(pair[0]);
        }

        for (int i = 0; i < words1.length; i++) {
            if (words1[i].equals(words2[i])) continue;
            if (!graph.containsKey(words1[i])) return false;
            if (graph.get(words1[i]).contains(words2[i])) continue;
            Set<String> visited = new HashSet<>();
            if (!dfs(graph, words1[i], words2[i], visited)) return false;
        }
        return true;
    }

    private boolean dfs(Map<String, Set<String>> graph, String w1, String w2, Set<String> visited) {
        if (!visited.contains(w1) && w1.equals(w2)) return true;
        visited.add(w1);

        for (String neighbour: graph.get(w1)) {
            if (!visited.contains(neighbour) && dfs(graph, neighbour, w2, visited)) return true;
            // dfs(graph, neighbour, w2, visited);
        }
        return false;
    }
}
