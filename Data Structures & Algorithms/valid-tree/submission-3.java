class Solution {
    public boolean validTree(int n, int[][] edges) {
        //just like course scheduling problem

        if (edges.length != n-1)
            return false;
        if (n == 1 && edges.length == 0)
            return true;
        
        HashMap<Integer, List<Integer>> neighbours = new HashMap<>();

        for (int[] edge : edges) {
            neighbours.putIfAbsent(edge[0], new ArrayList<>());
            neighbours.get(edge[0]).add(edge[1]);
            neighbours.putIfAbsent(edge[1], new ArrayList<>());
            neighbours.get(edge[1]).add(edge[0]);
            //might hae to add oppsiie side too
            // int smaller = Math.min(edge[0], edge[1]);
            // int bigger = Math.max(edge[0], edge[1]);
            // neighbours.putIfAbsent(smaller, new ArrayList<>());
            // neighbours.get(smaller).add(bigger);
        }

        //create hashmap of all edges

        HashSet<Integer> visited = new HashSet<>();

        if (!dfs(neighbours, visited, 0, -1))
            return false;
    
        
        return visited.size() == n;
        //need to be n nodes, and n-1 edges
        //but each edge needs to pair to its on
        //simialr to course schedule...!!! but undirected? (just alwas put bigger num first)

    }

    private boolean dfs(HashMap<Integer, List<Integer>> neighbours, HashSet<Integer> visited, int node, int par) {
        if (visited.contains(node)) 
            return false;
       
        visited.add(node);
        for (int neigh : neighbours.get(node)) {
            if (neigh != par && !dfs(neighbours, visited, neigh, node))
                return false;            
        }
        return true;
    }
}
