class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        HashMap<Integer, Integer> speeds = new HashMap<>();
        for (int i = 0; i < position.length; i++)
            speeds.put(position[i], speed[i]);

        Arrays.sort(position); //(a,b) -> (b[0], a[0])

        //want to map positions to speeds -- may
        Deque<Double> stack = new ArrayDeque<>();

        for (int i = position.length - 1; i >= 0; i--) {
            double timeToTarget = ((double)target - position[i]) / speeds.get(position[i]);

            if (stack.isEmpty() || timeToTarget > stack.peek())
                stack.push(timeToTarget);
        }

        return stack.size();


        
    }
}
