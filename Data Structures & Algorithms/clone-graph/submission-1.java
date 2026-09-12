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

        return cloning(node, clones);
    }

    private Node cloning(Node node, HashMap<Node, Node> clones) {
        if (clones.containsKey(node))
            return clones.get(node);

        Node clone = new Node(node.val);
        clones.put(node, clone);

        for (Node neigh : node.neighbors) {
            clone.neighbors.add(cloning(neigh, clones));
        }

        return clone;
        
    }
}












//         HashMap<Node, Node> clones = new HashMap<>();

//         if (node == null)
//             return null;

//         return dfs(node, clones);
        
//     }

//     private Node dfs(Node node, HashMap<Node, Node> clones) {
//         if (clones.containsKey(node)) {
//             return clones.get(node);
//         }

//         Node clone = new Node(node.val);
//         clones.put(node, clone);

//         for (Node neigh : node.neighbors) {
//             clone.neighbors.add(dfs(neigh, clones));
//         }

//         return clone;

//     }
// }