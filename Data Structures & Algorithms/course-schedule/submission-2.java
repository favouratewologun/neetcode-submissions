class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //if cycle return false, else return true

        //want a visited set of courses
        //want a hashmap of prereqs

        HashSet<Integer> visited = new HashSet<>();

        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for (int[] pair : prerequisites) {
            map.putIfAbsent(pair[0], new ArrayList<>());
            map.get(pair[0]).add(pair[1]);
        }

        for (int i = 0; i < numCourses; i++) {
            if (!dfs(visited, map, i))
                return false;
        }

        return true;
        
    }

    private boolean dfs(HashSet<Integer> visited, HashMap<Integer, List<Integer>> map, int course) {
        if (visited.contains(course)) //cycle found
            return false;
        if (!map.containsKey(course) || map.get(course).isEmpty()) //no prereqs, or satisfied
            return true;
        
        visited.add(course);
        for (int prereq : map.get(course)) {
            if (!dfs(visited, map, prereq))
                return false;
        }
        visited.remove(course);
        map.get(course).clear(); //confirmed its good, can clear all prereqs
        return true;
        

    }
}
