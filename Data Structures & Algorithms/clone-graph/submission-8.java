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
        if (node == null)
            return null;
            
        HashMap<Node, Node> clones = new HashMap<>();

        return clone(node, clones);
    }

    public Node clone(Node node, HashMap<Node, Node> clones) {
        if (clones.containsKey(node)) {
            return clones.get(node);
        }

        Node newClone = new Node(node.val);
        clones.put(node, newClone);

        for (Node neigh : node.neighbors) {
            newClone.neighbors.add(clone(neigh, clones));
        } 

        return newClone;
    }
}