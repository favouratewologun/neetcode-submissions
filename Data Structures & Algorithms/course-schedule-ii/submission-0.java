class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

        int[] numPres = new int[numCourses];

        for (int[] pre : prerequisites) {
            map.putIfAbsent(pre[1], new ArrayList<Integer>());
            map.get(pre[1]).add(pre[0]); //map a class to what its a prereq for

            numPres[pre[0]]++; //if has more prereqs, update its number
        }

        Queue<Integer> canTake = new LinkedList<>();

        for (int i = 0; i < numPres.length; i++)
            if (numPres[i] == 0)
                canTake.offer(i);

        int res[] = new int[numCourses];
        int ind = 0;

        while (!canTake.isEmpty()) {
            int course = canTake.poll();
            res[ind++] = course;
            if (!map.containsKey(course)) //if class isnt prereq for anything, move on
                continue;

            for (int next : map.get(course)) {
                numPres[next]--; //reduce num prereqs
                if (numPres[next] == 0)
                    canTake.offer(next);
            }
        }

        if (ind != numCourses)
            return new int[0];

        return res;

        
    }
    

}
