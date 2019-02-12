/**
 * Created on 12 Feb 2019 by happygirlzt
 * 
 * LeetCode #428. Serialize and Deserialize N-ary Tree
 */

 /*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Codec {

    // Encodes a tree to a single string.
    public String serialize(Node root) {
        if (root == null) return "";
        StringBuilder sb = new StringBuilder();
        buildString(root, sb);
        return sb.toString();
    }
    
    private void buildString(Node root, StringBuilder sb) {
        if (root == null) {
            return;
        }
        
        sb.append(root.val).append(",");
        int size = root.children.size();
        // Do not forget the comma
        sb.append(size).append(",");
        for (Node child : root.children) {
            buildString(child, sb);
        }
    }

    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        if (data.length() == 0) return null;
        String[] dataArray = data.split(",");
        LinkedList<String> dataList = new LinkedList<>(Arrays.asList(dataArray));
        return buildTree(dataList);
    }
    
    private Node buildTree(LinkedList<String> dataList) {
        Node root = new Node();
        String val = dataList.removeFirst();        
        root.val = Integer.parseInt(val);
        int size = Integer.parseInt(dataList.removeFirst());      
        root.children = new ArrayList<>(size);
        
        for (int i = 0; i < size; i++) {
            root.children.add(buildTree(dataList));
        }

        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));