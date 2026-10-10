class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        HashMap<Integer, ArrayList<Integer>> courses = new HashMap<>();

        int[] numPres = new int[numCourses];
        int[] res = new int[numCourses];
        int ind = 0;

        for (int i = 0; i < numCourses; i++) {
            courses.put(i, new ArrayList<>());
        }

        for (int pre[] : prerequisites) {
            courses.get(pre[1]).add(pre[0]); //map a class to all the ones its a prereq for
            numPres[pre[0]]++; //add 1 to number of prereqs
        }

        Queue<Integer> canTake = new ArrayDeque<>();
        HashSet<Integer> taken = new HashSet<>();

        for (int i = 0; i < numCourses; i++) {
            if (numPres[i] == 0)
                canTake.offer(i);
        }

        while (!canTake.isEmpty()) {
            int course = canTake.poll();
            taken.add(course);
            res[ind++] = course;
            for (int follow : courses.get(course)) {
                numPres[follow]--;
                if (numPres[follow] == 0)
                    canTake.offer(follow);
            }
        }

        if (taken.size() != numCourses)
            return new int[0];

        return res;


        
    }
}
