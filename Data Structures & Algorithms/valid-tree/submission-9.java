class Solution {
    public boolean validTree(int n, int[][] edges) {
        
        if (edges.length != n - 1)
            return false;

        if (n == 1 && edges.length == 0)
            return true;

        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

        //all nodes have all neighbours
        for (int[] edge : edges) {
            map.putIfAbsent(edge[0], new ArrayList<Integer>());
            map.putIfAbsent(edge[1], new ArrayList<Integer>());

            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);

        }

        HashSet<Integer> checked = new HashSet<>();
        // for (int i = 0; i < n; i++) {
        if (!check(0, map, checked, new HashSet<>(), -1))
            return false;
        

        return checked.size() == n;

    }

//need to check if its the parent
    private boolean check(int i, HashMap<Integer, ArrayList<Integer>> map, HashSet<Integer> checked, HashSet<Integer> visited, int par) {
        if (visited.contains(i)) //cycle
            return false;

        if (checked.contains(i)) //already checked, we're good
            return true;

        visited.add(i);
        for (int neigh : map.get(i)) { //check all neighbours
            if (neigh == par) //if parent, will cause loop even tho valid, skip it
                continue;
            if (!check(neigh, map, checked, visited, i))
                return false;
        }

        visited.remove(i);
        checked.add(i);
        return true;

    }
}
