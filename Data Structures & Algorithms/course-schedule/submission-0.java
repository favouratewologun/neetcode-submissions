class Solution {
    //course we want is first number, prereq is second 
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //just possible if there are no cycles...so build graph and look for cycle detection?

        HashMap<Integer, List<Integer>> preReqs = new HashMap<>();

        for (int[] preReq : prerequisites) {
            preReqs.putIfAbsent(preReq[0], new ArrayList<>()); //create new pair if not alr there
            preReqs.get(preReq[0]).add(preReq[1]);  //append prereq to list
        }

        HashSet<Integer> visited = new HashSet<>();
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(preReqs, i, visited))
                return false;
        }

        return true;
        
    }

    private boolean dfs(HashMap<Integer, List<Integer>> preReqs, int currCourse, HashSet<Integer> visited) {
        if (visited.contains(currCourse)) //found a cycle
            return false;
        if (!preReqs.containsKey(currCourse) || preReqs.get(currCourse).isEmpty())
            return true;
        visited.add(currCourse);

        for (int preReq : preReqs.get(currCourse)) {
            if (!dfs(preReqs, preReq, visited)) //if prereq is in cycle, return false
                return false;       
        }

        visited.remove(currCourse);
        preReqs.get(currCourse).clear();  
        return true; 

    }


}
