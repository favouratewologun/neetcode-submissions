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


        visited.add(i); //im exploring the prereqs of course i
        for (int num : preReqs.get(i)) { //for all i's prereqs
            if (!dfs(num, preReqs, visited)) //if any of them fail, i fails. return false
                return false;
        }
        visited.remove(i); //none of is prereqs failed, so i can also be compelted
        preReqs.get(i).clear(); //clear its prereq list bc we know it works

        return true; //i is clear!
        
    }
}
