class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1)
            return false;

        if (n == 1 && edges.length == 0)
            return true;

        HashSet<Integer> visited = new HashSet<>();
        HashMap<Integer, ArrayList<Integer>> neighbours = new HashMap<>();

        for (int[] edge : edges) {
            neighbours.putIfAbsent(edge[0], new ArrayList<>());
            neighbours.putIfAbsent(edge[1], new ArrayList<>());

            neighbours.get(edge[0]).add(edge[1]);            
            neighbours.get(edge[1]).add(edge[0]);
        }

        boolean valid = dfs(neighbours, visited, 0, -1);

        return valid && visited.size() == n;

        //create visited set,
        //create hashmap of edges (both ends)
        //go through graph, explore all...if in visited and isnt parent, return false
    }

    public boolean dfs(HashMap<Integer, ArrayList<Integer>> neighbours, HashSet<Integer> visited, int curr, int par){ 
        if (visited.contains(curr)) //cycle found, just end it
            return false;

        visited.add(curr);
        for (int neigh : neighbours.get(curr)) {
            if (neigh != par && !dfs(neighbours, visited, neigh, curr))
                return false;
        }

        return true;
        
    }
}
