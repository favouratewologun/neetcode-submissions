class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //possible to finish all courses if there are no cycles. not poss if there are cycles
        //create map of all courses and prereqs
        //go through each course, do dfs. if prereqs can be solved then is good. if not then not good. false for whole also
        //recusive dfs?

        HashMap<Integer, ArrayList<Integer>> preReqs = new HashMap<>();

        for (int[] prereq : prerequisites) {
            preReqs.putIfAbsent(prereq[0], new ArrayList<>());
            preReqs.get(prereq[0]).add(prereq[1]);
        }

        //now have map of class to its prereqs
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i, preReqs, new HashSet<Integer>()))
                return false;
        }

        return true;
        
    }

    //need to keep track of what is in my visited set;
    private boolean dfs(int i, HashMap<Integer, ArrayList<Integer>> preReqs, HashSet<Integer> visited) {
        if (visited.contains(i)) //cycle detected
            return false;

        if (!preReqs.keySet().contains(i) || preReqs.get(i).isEmpty()) {  //no prereqs or all cleared
            return true;
        }

        visited.add(i);
        for (int num : preReqs.get(i)) {
            if (!dfs(num, preReqs, visited))
                return false;
        }
        visited.remove(i);
        preReqs.get(i).clear();

        return true;
        
    }
}
