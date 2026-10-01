class Solution {
    public int countComponents(int n, int[][] edges) {
       //do an expansion on each node, mark as visited, then add
       //simialr to number of islands

        int comps = 0;

        ArrayList<Integer>[] nodes = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new ArrayList<Integer>();
        }

        for (int[] edge : edges) {
            nodes[edge[0]].add(edge[1]);
            nodes[edge[1]].add(edge[0]);
        }

        HashSet<Integer> visited = new HashSet<>();
        for (int i = 0; i < n; i++) {
            int prev_s = visited.size();
            expand(i, nodes, visited);
            if (visited.size() > prev_s)
                comps++;
        }

        return comps;

    }

    public void expand(int i, ArrayList<Integer>[] nodes, HashSet<Integer> visited ) {
        if (visited.contains(i)) //already expanded or part of smth that was expanded
            return;

        visited.add(i);

        for (int neigh : nodes[i]) {
            expand(neigh, nodes, visited);
        }
    }
}
