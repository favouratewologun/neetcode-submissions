class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

        for (int[] prereqs : prerequisites) {
            map.putIfAbsent(prereqs[0], new ArrayList<>());
            map.get(prereqs[0]).add(prereqs[1]);
        }

        //hashmap of all classes to prereqs
        for (int i = 0; i < numCourses; i++) {
            HashSet<Integer> v = new HashSet<>();
            boolean c = check(map, i, v);
            if (!c)
                return false;
        }

        return true;
        
    }

    public boolean check(HashMap<Integer, ArrayList<Integer>> map, int i, HashSet<Integer> v) {
        if (v.contains(i)) //cycle detected
            return false;
         
        if (!map.containsKey(i) || map.get(i).isEmpty()) //the class has no prereqs or has been cleared
            return true;

        v.add(i);
        for (int pre : map.get(i)) {
            boolean c = check(map, pre, v);
            if (!c) //if one of prereqs has cycles, false
                return false;
        }

        //for efficiency
        map.get(i).clear();
        v.remove(i); //no longer checking
        return true;
    }
}

//want to run through all courses, make sure prereqs can be completed.
//need a visited set,