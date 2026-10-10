class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, ArrayList<Integer>> prereq = new HashMap<>();

        for (int[] pre : prerequisites) {
            prereq.putIfAbsent(pre[0], new ArrayList<>());
            prereq.get(pre[0]).add(pre[1]);
        }

        HashSet<Integer> done = new HashSet<>();

        for (int i = 0; i < numCourses; i++) {
            if (!canTake(i, prereq, done, new HashSet<Integer>()))
                return false;
            // done.add(i);
        }

        return true;
    }

    public boolean canTake(int i, HashMap<Integer, ArrayList<Integer>> prereq, HashSet<Integer> done, HashSet<Integer> inPath) {
        if (inPath.contains(i)) //if in path, cycle, return false
            return false;
        
        if (done.contains(i)) //if done class, return true
            return true;

        if (!prereq.containsKey(i)) //if class has no prereqs, then obvs good
            return true;

        inPath.add(i);

        for (Integer course : prereq.get(i)) {
            if (!canTake(course, prereq, done, inPath))
                return false;
        }

        inPath.remove(i);
        done.add(i);
        return true;
    }
}
