/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        //keep track of what we've alr cloned...(do dfs)
        //if alr cloned, get the cloned version and add...if not, create the clone

        if (node == null)
            return null;

        HashMap<Node, Node> map = new HashMap<>();
        return clone(node, map);
    }

    private Node clone(Node node, HashMap<Node, Node> map) {
        if (map.containsKey(node)) //if cloned vers already exists, return it
            return map.get(node);

        Node newClone = new Node(node.val);

        map.put(node, newClone);

        for (Node neighbor : node.neighbors) 
            newClone.neighbors.add(clone(neighbor, map));

        return newClone;
    }
}