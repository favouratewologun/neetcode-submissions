class Solution {
    public boolean validTree(int n, int[][] edges) {
        HashMap<Integer, ArrayList<Integer>> e = new HashMap();
        if (edges.length != n - 1)
            return false; 
            
        for (int i = 0; i < n; i++)
            e.put(i, new ArrayList<Integer>());

        for (int[] edge : edges) {
            e.get(edge[0]).add(edge[1]);
            e.get(edge[1]).add(edge[0]);
        }

        HashSet<Integer> seen = new HashSet<>();
        HashSet<Integer> done = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (!check(i, seen, done, e, -1))
                return false;
        }

        return true;

    }

    public boolean check(int i, HashSet<Integer> seen, HashSet<Integer> done, HashMap<Integer, ArrayList<Integer>> e, int par) {
        if (done.contains(i)) //alr good to go
            return true;

        if (seen.contains(i)) //cycle detected
            return false;

        seen.add(i);
        for (int neigh : e.get(i)) {
            if (neigh != par && !check(neigh, seen, done, e, i)) //if not neighbour parent but fails
                return false;
        }

        done.add(i);
        seen.remove(i);
        return true;
    }
}
