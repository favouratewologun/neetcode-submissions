class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        
        ArrayList<Integer>[] neighs = new ArrayList[edges.length + 1];

        for (int i = 0; i < neighs.length; i++)
            neighs[i] = new ArrayList<Integer>();

        for (int[] edge : edges) {
            neighs[edge[0]].add(edge[1]);
            neighs[edge[1]].add(edge[0]);

            HashSet<Integer> visited = new HashSet<>();

            if (!nocycle(edge[0], neighs, visited, -1)) {
                return edge;
            }

        }

        return new int[0];
        
    }

    private boolean nocycle(int s, ArrayList<Integer>[] neighs, HashSet<Integer> visited, int par) {
        if (visited.contains(s))
            return false;
        
        visited.add(s);
        for (int neigh : neighs[s]) {
            if (neigh != par && !nocycle(neigh, neighs, visited, s))
                return false;
        }

        // visited.remove(s);
        return true;
    }
}
