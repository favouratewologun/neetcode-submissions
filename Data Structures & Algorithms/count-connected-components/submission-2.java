class Solution {
    public int countComponents(int n, int[][] edges) {     

        //create arryalist of hashsets of edges tgt...if not in one, create  new hasset, return size of list

        ArrayList<HashSet<Integer>> res = new ArrayList<>();
        HashMap<Integer, ArrayList<Integer>> e = new HashMap<>();

        HashSet<Integer> seen = new HashSet<>();

        for (int i = 0; i < n; i++) {
            e.put(i, new ArrayList<>());
        }

        for (int[] edge : edges) {
            e.get(edge[0]).add(edge[1]);
            e.get(edge[1]).add(edge[0]);
            
        }

        int num = 0;
        for (int i = 0; i < n; i++) {
            int currSeen = seen.size();
            expand(i, seen, e);
            if (seen.size() > currSeen)
                num++;
        }
            

        return num;
    }

    public void expand(int i, HashSet<Integer> seen, HashMap<Integer, ArrayList<Integer>> e) {
        if (seen.contains(i))
            return;

        seen.add(i);
        for (int next : e.get(i))  {
            if (!seen.contains(next))
                expand(next, seen, e);
        }
            

    } 
}
