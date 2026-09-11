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

//do a bfs...create a queue

//go through every element in the queue
//when you see an element in the queue. 
//remove it from the queue. create a new node, 

class Solution {
    public Node cloneGraph(Node node) {
        HashMap<Node, Node> clones = new HashMap<>();

        if (node == null)
            return null;

        return dfs(node, clones);
        
    }

    private Node dfs(Node node, HashMap<Node, Node> clones) {
        if (clones.containsKey(node)) {
            return clones.get(node);
        }

        Node clone = new Node(node.val);
        clones.put(node, clone);

        for (Node neigh : node.neighbors) {
            clone.neighbors.add(dfs(neigh, clones));
        }

        return clone;

    }
}