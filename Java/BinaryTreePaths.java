/**
 * LeetCode #257. Binary Tree Path Created on 2018-8-24
 *
 * @author happygirlzt
 *
 */
import java.util.List;
import java.util.ArrayList;

public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root != null) {
            helper(root, "", res);
        }
        return res;
    }

    public void helper(TreeNode root, String s, List<String> res) {
        if (root.left == null && root.right == null) {
            res.add(s +
    public List<String> findItinerary(String[][] tickets) {
        Map<String, PriorityQueue<String>> flights = new HashMap<>();
        LinkedList<String> res = new LinkedList<>();

        for (String[] ticket : tickets) {
            flights.putIfAbsent(ticket[0], new PriorityQueue<>());
            flights.get(ticket[0]).add(ticket[1]);
        }

        dfs("JFK", flights, res);
        return res;
    }

    public void dfs(String dep, Map<String, PriorityQueue<String>> flights, LinkedList<String> res) {
        PriorityQueue<String> arrivals = flights.get(dep);
        while (arrivals != null && !arrivals.isEmpty()) {
            dfs(arrivals.poll(), flights, res);
        }

        res.addFirst(dep);
    }

    // Updated on 9 Feb 2019
    public List<String> findItinerary1(String[][] tickets) {
        Map<String, PriorityQueue<String>> graph = new HashMap<>();
        List<String> res = new ArrayList<>();
        for (String[] travel: tickets) {
            String out = travel[0], in = travel[1];
            graph.putIfAbsent(out, new PriorityQueue<>());
            graph.get(out).add(in);
        }

        dfs("JFK", graph, res);
        return res;
    }

    private void dfs(String out, Map<String, PriorityQueue<String>> graph, List<String> res) {
        PriorityQueue<String> ins = graph.get(out);
        while (ins != null && !ins.isEmpty()) {
            dfs(ins.poll(), graph, res);
        }
        res.add(0, out);
    }

    // Updated on 9 Mar 2019
    public List<String> findItinerary(String[][] tickets) {
        LinkedList<String> res = new LinkedList<>();
        Map<String, PriorityQueue<String>> g = new HashMap<>();
        buildGraph(g, tickets);
        dfs(g, "JFK", res);
        return res;
    }

    private void dfs(Map<String, PriorityQueue<String>> g, String from, LinkedList<String> res) {
        PriorityQueue<String> arrivals = g.get(from);
        while (arrivals != null && !arrivals.isEmpty()) {
            String to = arrivals.poll();
            dfs(g, to, res);

        }
        res.addFirst(from);
    }

    private void buildGraph(Map<String, PriorityQueue<String>> g, String[][] tickets) {
        for (String[] travel : tickets) {
            String from = travel[0];
            String to = travel[1];
            g.putIfAbsent(from, new PriorityQueue<>());
            g.get(from).offer(to);
        }
    }
}
root.val);
        }

        if (root.left != null) {
            helper(root.left, s + root.val + "->", res);
        }

        if (root.right != null) {
            helper(root.right, s + root.val + "->", res);
        }
    }

    // Updated on 5 Feb 2019
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) return res;
        helper(res, "", root);
        return res;
    }

    private void helper(List<String> res, String tmp, TreeNode root) {
        if (root == null) return;
        tmp += root.val;
        if (root.left == null && root.right == null) {
            res.add(tmp);
        }

        helper(res, tmp + "->", root.left);
        helper(res, tmp + "->", root.right);
    }

    // Updated on 5 Feb 2019
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) return res;
        StringBuilder sb = new StringBuilder();
        helper(res, sb, root);
        return res;
    }

    private void helper(List<String> res, StringBuilder sb, TreeNode root) {
        if (root == null) return;

        int len = sb.length();
        sb.append(root.val);
        if (root.left == null && root.right == null) {
            res.add(sb.toString());
        }
        sb.append("->");
        helper(res, sb, root.left);
        helper(res, sb, root.right);
        sb.setLength(len);
    }

    // Updated on 9 Mar 2019
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) return res;
        StringBuilder sb = new StringBuilder();
        sb.append(root.val);
        helper(res, root, sb);
        return res;
    }

    private void helper(List<String> res, TreeNode root, StringBuilder sb) {
        int len = sb.length();
        if (root == null) return;
        if (root.left == null && root.right == null) {
            res.add(sb.toString());
            sb.setLength(len);
            return;
        }
        if (root.left != null) {
            sb.append("->");
            sb.append(root.left.val);
            helper(res, root.left, sb);
            sb.setLength(len);
        }
        if (root.right != null) {
            sb.append("->");
            sb.append(root.right.val);
            helper(res, root.right, sb);
            sb.setLength(len);
        }
    }
}
